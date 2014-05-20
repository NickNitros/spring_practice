package com.nickforum.service;

import java.util.List;

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

	public boolean login(String email, String password) {

		Query query = em
				.createQuery("SELECT new com.nickforum.model.User(u.id, u.name, u.email, u.password) FROM User u"
						+ " WHERE u.email = '" + email + "'");

		if (query.getResultList().isEmpty()) {
			return false;
		} else {
			User inDB = (User) query.getResultList().get(0);

			return inDB.getPassword().equals(password);
		}
	}

	public void save(User u) {
		userRepository.save(u);
	}

	public boolean checkExists(String email) {
		Query query = em
				.createQuery("SELECT COUNT(u.email) FROM User u WHERE u.email = '"
						+ email + "'");
		int result = Integer.parseInt(query.getResultList().get(0).toString());
		return result > 0;
	}

	public User findUser(Long id) {
		System.out.println("Looking for " + id);
		return userRepository.findOne(id);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public void delete(Long id) {
		userRepository.delete(id);
	}

}
