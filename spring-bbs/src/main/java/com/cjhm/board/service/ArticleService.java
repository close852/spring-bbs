package com.cjhm.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cjhm.board.domain.Article;
import com.cjhm.board.repository.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	ArticleRepository articleRepository;
	public void deleteArticle(Long id) {
		articleRepository.deleteById(id);
	}

	public Article saveAndUpdateArticle(Article article) {
		return articleRepository.save(article);
	}

	public Page<Article> findArticleList(Pageable pageable) {
    	Sort defaultSort = new Sort(Direction.ASC,"articleId");
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize(),pageable.getSortOr(defaultSort));
		return articleRepository.findAll(pageable);
	}
	public Page<Article> findArticleListDefault(Long boardId,Pageable pageable) {
		Sort defaultSort = new Sort(Direction.DESC,"refarticleId");
		defaultSort.and(new Sort(Direction.ASC,"indent"));
		defaultSort.and(new Sort(Direction.ASC,"sortno"));
		pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize(),(defaultSort));
		return articleRepository.findAllByBoardId(boardId,pageable);

	}
	public Page<Article> findArticleList(Long boardId,Pageable pageable) {
		Sort defaultSort = new Sort(Direction.ASC,"articleId");
		pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize(),pageable.getSortOr(defaultSort));
		return articleRepository.findAllByBoardId(boardId,pageable);
	}
	public Page<Article> findArticleListByBoardId(Pageable pageable) {
		Sort defaultSort = new Sort(Direction.ASC,"articleId");
		pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize(),pageable.getSortOr(defaultSort));
		return articleRepository.findAll(pageable);
	}

	public Article findArticleByIdx(Long idx) {
		return articleRepository.findById(idx).orElse(new Article());
	}

	public int getSortNoByUparticleId(Long uparticleId) {
		// TODO Auto-generated method stub
		return articleRepository.countByUparticleId(uparticleId)+1;
	}

}
