package com.nickforum.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nickforum.model.Reply;
import com.nickforum.repository.ReplyRepository;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyRepository replyRepository;

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Reply> getReplies(Long topicID) {
		Query query = em
				.createQuery("SELECT new com.nickforum.model.Reply(r.id, r.text, r.topic, r.user) FROM Reply r WHERE r.topic.id = "
						+ topicID + "");
		return query.getResultList();
	}
}
