package com.nickforum.service;

import java.util.List;

import com.nickforum.model.User;

public interface UserService {

	User findUser(Long id);
	
	User findByEmail(String email);
	
	List<User> findAll();
	
	boolean checkExists(String email);

	boolean login(String email, String password);

	void save(User u);
	
	void delete(Long id);
}
