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

	/**
	 * Create an authentication string for a provided user. This key gets stored
	 * in the database
	 * 
	 * @param user
	 *            The user requiring an authentication string
	 * @return The authentication string
	 */
	public String createAuthString(User user) {
		String key = KeyGenerators.string().generateKey();
		Authorised au = new Authorised(key,
				new Date(System.currentTimeMillis()), user);
		authService.saveAuth(au);
		return key;
	}

	/**
	 * Validates the provided authentication string against the database to
	 * check validity
	 * 
	 * @param auth
	 *            The authentication string
	 * @return Authorised object with link to user
	 * @throws AuthenticationFailedException
	 *             If the authentication key does not match any active records
	 */
	public Authorised validateAuthString(String auth)
			throws AuthenticationFailedException {
		Authorised rec = authService.getAuth(auth);
		if (rec == null) {
			throw new AuthenticationFailedException();
		}
		return rec;
	}
}

class AuthenticationFailedException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Authentication has failed.";
	}
}
