package com.cjhm.board.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cjhm.board.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	Page<Article> findAllByBoardId(Long boardId,Pageable pageable);
	Integer countByUparticleId(Long uparticleId);
}
