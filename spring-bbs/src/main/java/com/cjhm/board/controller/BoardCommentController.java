package com.cjhm.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjhm.board.domain.Article;
import com.cjhm.board.domain.Comment;
import com.cjhm.board.service.ArticleService;
import com.cjhm.board.service.BoardService;
import com.cjhm.board.service.CommentService;

@Controller
@RequestMapping("/board")
public class BoardCommentController {

	Logger logger = LoggerFactory.getLogger(BoardCommentController.class);

	@Autowired
	ArticleService articleService;
	
	@Autowired
	BoardService boardService;

	@Autowired
	CommentService commentService;
	@GetMapping("/comment")
	public String articleList(@RequestParam(defaultValue="0") Long boardId, @PageableDefault Pageable pageable, Model model) {
		logger.debug("GET /board/article/list params: boardId="+boardId+"&page="+pageable);

		Page<Article> articleList = articleService.findArticleListDefault(boardId,pageable);
		model.addAttribute("articleList", articleList);
		return "board/list";
	}

	@PostMapping("/comment")
	public String commentInsert(String cmtContent,Long cmtArticleId) {
		logger.debug("POST /board/comment params: comment="+cmtContent+", articleId="+cmtArticleId);
		Comment cmt = commentService.insertComment(cmtContent, cmtArticleId);
		return "redirect:/board/article?articleId="+cmtArticleId;
	}
	@DeleteMapping("/comment")
	public String commentDelete(Long cmtId,Long cmtArticleId) {
		logger.debug("DELETE /board/comment params: commentId="+cmtId);
		commentService.removeComment(cmtId);
		return "redirect:/board/article?articleId="+cmtArticleId;
	}
}
