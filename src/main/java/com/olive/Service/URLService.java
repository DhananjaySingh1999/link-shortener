package com.olive.Service;

import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.olive.Repository.URLMappingRepository;
import com.olive.model.URLMapping;

@Service
public class URLService {
	
	 @Autowired
	 private URLMappingRepository Repository;
	 
	 public String shortURL(String longURL) {
	        String shortURL = generateShortURL();
	        URLMapping url = new URLMapping();
	        url.setLongURL(longURL);
	        url.setShortURL(shortURL);
	        url.setExpirationTime(new Date(System.currentTimeMillis() + 5 * 60 * 1000)); 
	        Repository.save(url);
	        return shortURL;
	    }

	    public String getLongURL(String shortURL) {
	        URLMapping urlMapping = Repository.findByShortURL(shortURL);
	        System.out.println("req::"+shortURL);
	        if (urlMapping != null && urlMapping.getExpirationTime().after(new Date())) {
	            return urlMapping.getLongURL();
	        } else {
	            return "URL is expired or does not exist!";
	        }
	    }

	    private String generateShortURL() {
	        return "http://localhost:9191/" + generateRandomString(8);
	    }
	    
	    public static String generateRandomString(int length) {
	        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
	        return uuid.substring(0, Math.min(length, uuid.length()));
	    }

}
