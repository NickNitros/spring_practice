package com.nickforum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reply {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private String text;

	@ManyToOne
	private Topic topic;

	@ManyToOne
	private User user;

	public Reply() {

	}

	public Reply(Long id, String text, Topic topic, User user) {
		super();
		this.id = id;
		this.text = text;
		this.topic = topic;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public Topic getTopic() {
		return topic;
	}

	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
