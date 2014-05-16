package com.nickforum.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Topic {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private String title;

	@NotNull
	private String description;

	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Reply> replies;

	public String getDescription() {
		return description;
	}

	public Long getId() {
		return id;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public String getTitle() {
		return title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
