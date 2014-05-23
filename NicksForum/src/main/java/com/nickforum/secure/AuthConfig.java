package com.nickforum.secure;

import java.sql.Date;

import org.springframework.security.crypto.keygen.KeyGenerators;

import com.nickforum.model.Authorised;
import com.nickforum.model.User;

public class AuthConfig {
	
	public static String createAuthString(User user) {
		String key = KeyGenerators.string().generateKey();
		Authorised au = new Authorised(key,
				new Date(System.currentTimeMillis()), user);

		return key;
	}

	public static boolean validateAuthString(String auth) {
		return false;
	}
}
