package com.nickforum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nickforum.model.Authorised;

@Repository("authRepository")
public interface AuthRepository extends JpaRepository<Authorised, Long> {

}
