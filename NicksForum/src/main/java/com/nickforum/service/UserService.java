package com.nickforum.service;

import com.nickforum.model.User;

public interface UserService {

	boolean checkExists(String email);

	boolean login(String email, String password);

	void save(User u);
}
