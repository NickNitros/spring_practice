package com.nickforum.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;

	@NotNull(message = "Name is required!")
	@Size(min = 1, message = "Name must not be blank!")
	private String name;

	@Column(unique = true)
	@Size(min = 1, message = "Email must not be blank!")
	@NotNull
	private String email;

	@NotNull
	@Size(min = 5, message = "Password must be at least 5 characters!")
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "user_role")
	private Role role;

	public Role getAccess() {
		return role;
	}

	public void setAccess(Role role) {
		this.role = role;
	}

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Reply> replies;

	public User() {
	}

	public User(Long id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = Role.ROLE_ADMIN;
	}

	public String getEmail() {
		return email;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

}
