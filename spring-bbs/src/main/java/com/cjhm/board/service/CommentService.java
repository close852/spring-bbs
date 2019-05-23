package com.cjhm.board.service;

import org.springframework.stereotype.Service;

import com.cjhm.board.domain.Article;
import com.cjhm.board.domain.Comment;
import com.cjhm.board.repository.CommentRepository;

@Service
public class CommentService {

	private CommentRepository commentRepository;
	private ArticleService articleService;

	public CommentService(ArticleService articleService, CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
		this.articleService = articleService;
	}

	public Comment insertComment(Comment comment) {
		return commentRepository.save(comment);
	}

	public Comment insertComment(String content, Long articleId) {
		Article article = articleService.findArticleByIdx(articleId);
		content = makeHTML(content);
		Comment comm = Comment.builder()
							.content(content)
							.indent(1)
							.sortno(1)
							.build();
		comm.addArticle(article);
		comm = commentRepository.save(comm);
		comm.setRefcommentId(comm.getCommentId());
		comm = commentRepository.save(comm);
		return comm;
	}
	
	public void removeComment(Long commentId) {
		commentRepository.deleteById(commentId);
	}

	private String makeHTML(String content) {
		System.out.println("1 cont : "+content);
		content =content.replace(" ", "&nbsp;");
		content =content.replace("<", "&lt;");
		content =content.replace(">", "&gt;");
		content =content.replace("\n", "<br>");
		System.out.println("2 cont : "+content);
		return content;
	}
}
