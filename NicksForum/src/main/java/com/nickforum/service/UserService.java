package com.nickforum.service;

import com.nickforum.model.User;

public interface UserService {
	boolean login(User u);
	
	void save(User u);
}
