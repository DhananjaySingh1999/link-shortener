package com.olive.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_URLMapping")
public class URLMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private long uid;
	
	@Column(name = "LONGURL")
	private String longURL;
	
	@Column(name = "SHORTURL")
	private String shortURL;
	
	@Column(name = "EXPIRATIONTIME")
	private Date expirationTime;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getLongURL() {
		return longURL;
	}

	public void setLongURL(String longURL) {
		this.longURL = longURL;
	}

	public String getShortURL() {
		return shortURL;
	}

	public void setShortURL(String shortURL) {
		this.shortURL = shortURL;
	}

	public Date getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}

	@Override
	public String toString() {
		return "URLMapping [uid=" + uid + ", longURL=" + longURL + ", shortURL=" + shortURL + ", expirationTime="
				+ expirationTime + "]";
	}
	
	
}
