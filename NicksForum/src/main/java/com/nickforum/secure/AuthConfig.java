package com.nickforum.secure;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Component;

import com.nickforum.model.Authorised;
import com.nickforum.model.User;
import com.nickforum.service.AuthService;

@Component
public class AuthConfig {

	@Autowired
	private AuthService authService;

	public String createAuthString(User user) {
		String key = KeyGenerators.string().generateKey();
		Authorised au = new Authorised(key,
				new Date(System.currentTimeMillis()), user);
		authService.saveAuth(au);
		return key;
	}

	public Authorised validateAuthString(String auth) {
		try {
			Authorised rec = authService.getAuth(auth);
			return rec;
		} catch (Exception e) {
			return null;
		}
	}

}
