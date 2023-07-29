package com.olive.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.olive.Service.URLService;

@Controller
public class URLShortController {
	
    @Autowired
    private URLService urlService;

    @GetMapping("/")
    public String showHomePage() {
    	//Consedering Page Comming while click /
        return "urlpage";
    }

    @PostMapping("/short")
    public String shortURL(@RequestParam String longURL, Model model) {
        String shortURL = urlService.shortURL(longURL);
        model.addAttribute("shortURL", shortURL);
        return "urlpage";
    }

    @GetMapping("/sendGetRequest")
    public ResponseEntity<String> LongURL(@RequestParam String shortUrl) {
    	System.out.println("shortUrl URL::"+shortUrl);
        String longURL = urlService.getLongURL(shortUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Login-URL", longURL);
        return new ResponseEntity<>("Login URL is set", headers, HttpStatus.OK);
    }
}


