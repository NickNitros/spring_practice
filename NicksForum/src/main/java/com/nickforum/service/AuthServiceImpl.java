package com.nickforum.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.nickforum.model.Authorised;
import com.nickforum.repository.AuthRepository;

public class AuthServiceImpl implements AuthService {

	@Autowired
	AuthRepository authRepo;

	@PersistenceContext
	private EntityManager em;

	public List<Authorised> getAuthorised() {
		return authRepo.findAll();
	}

	public Authorised getAuth(String auth) {
		Query query = em
				.createQuery("SELECT new com.nickforum.model.Authorised FROM authorised a"
						+ " WHERE a.token = '" + auth + "'");

		return (Authorised) query.getResultList().get(0);
	}

}
