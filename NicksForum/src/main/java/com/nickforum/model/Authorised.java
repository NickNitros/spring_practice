package com.nickforum.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Authorised {

	@Id
	private String token;
	
	@NotNull
	private Date expiry;
	
	@OneToOne
	private User user;
	
	public Authorised() {
		
	}

	public Authorised(String token, Date expiry, User user) {
		super();
		this.token = token;
		this.expiry = expiry;
		this.user = user;
	}

	public Date getExpiry() {
		return expiry;
	}

	public String getToken() {
		return token;
	}

	public User getUser() {
		return user;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
