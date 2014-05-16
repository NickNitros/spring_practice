package com.nickforum.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nickforum.model.User;
import com.nickforum.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@PersistenceContext
	private EntityManager em;

	public boolean login(User u) {
		
		Query query = em.createQuery("SELECT new com.nickforum.model.User(u.id, u.name, u.email, u.password) FROM User u"
				+ " WHERE u.email = '" + u.getEmail() + "'");

		if(query.getResultList().isEmpty()) {
			return false;
		} else {
			User inDB = (User)query.getResultList().get(0);
			
			return inDB.getPassword().equals(u.getPassword());
		}
	}

	public void save(User u) {
		userRepository.save(u);		
	}

	
}
