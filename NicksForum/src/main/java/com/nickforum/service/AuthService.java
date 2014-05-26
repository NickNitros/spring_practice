package com.nickforum.service;

import java.util.List;

import com.nickforum.model.Authorised;

public interface AuthService {
	List<Authorised> getAuthorised();
	
	Authorised getAuth(String auth);
	
	boolean saveAuth(Authorised auth);
}
