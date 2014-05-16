package com.nickforum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nickforum.model.Reply;

@Repository("replyRepository")
public interface ReplyRepository extends JpaRepository<Reply, Long>{

}
