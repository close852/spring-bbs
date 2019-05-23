package com.cjhm.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjhm.board.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	
}
