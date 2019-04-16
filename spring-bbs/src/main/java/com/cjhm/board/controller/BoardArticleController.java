package com.cjhm.board.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cjhm.bbs.domain.User;
import com.cjhm.board.domain.Article;
import com.cjhm.board.domain.Board;
import com.cjhm.board.service.ArticleService;
import com.cjhm.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardArticleController {

	Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	ArticleService articleService;
	
	@Autowired
	BoardService boardService;
	@GetMapping("/article" )
	public String article(@RequestParam(defaultValue="0") Long boardId,@RequestParam(defaultValue="0") Long articleId, Model model) {
		logger.debug("GET /board/article params:"+"articleId="+articleId+"&boardId="+boardId);
		Article article = articleService.findArticleByIdx(articleId);
		Board board  =boardService.findBoardByIdx(boardId);
//		System.out.println("get article -> "+article+"/"+board);
		List<Board> boardList  = boardService.findBoardList(board.getCategoryId());
		//boardId, boardList
		model.addAttribute("article", article);
		model.addAttribute("boardId", boardId);
		model.addAttribute("boardList", boardList);
		return "board/view";
	}
	@GetMapping("/article/index" )
	public String articleIndex(@RequestParam(defaultValue="0") Long boardId,@RequestParam(defaultValue="0") Long articleId, Model model) {
		logger.debug("GET /board/article/index params : boardId="+boardId);
		Article article = articleService.findArticleByIdx(articleId);
		Board board  =boardService.findBoardByIdx(boardId);
//		System.out.println("get article -> "+article+"/"+board);
		List<Board> boardList  = boardService.findBoardList(board.getCategoryId());
		//boardId, boardList
		model.addAttribute("article", article);
		model.addAttribute("boardId", boardId);
		model.addAttribute("boardList", boardList);
		return "board/index";
	}

	@GetMapping("/article/list")
	public String articleList(@RequestParam(defaultValue="0") Long boardId, @PageableDefault Pageable pageable, Model model) {
		logger.debug("GET /board/article/list params: boardId="+boardId+"&page="+pageable);

		Page<Article> articleList = articleService.findArticleList(boardId,pageable);
		model.addAttribute("articleList", articleList);
		return "board/list";
	}

	@PostMapping("/article")
	public String articleInsert(Article article) {
		logger.debug("POST /board/article params: article="+article);
		Article a = articleService.saveAndUpdateArticle(article);
		logger.debug("bbs insert :: "+a);
		return "redirect:/board/article?articleId="+a.getArticleId()+"&boardId="+article.getBoardId();
	}
	
	@PutMapping("/article")
	public String articleUpdate(Long articleId,Long boardId, String title,String content,Long userId,String createDate,HttpSession session) {
		User user = (User)session.getAttribute("SESSION_USER");
		user = new User();
		Article article =Article.builder()
				.articleId(articleId)
				.boardId(boardId)
//				.board(board)
				.createDate(LocalDateTime.parse(createDate))
				.title(title)
				.content(content)
				.userId(userId)
				.updateId(user.getIdx())
				.build();
		logger.debug("PUT /board/article params: article="+article);
		System.out.println("articleUpdate > "+articleId+"/"+boardId+"/"+title+"/"+content+"/"+userId+"/"+createDate);
		Article article2 = articleService.saveAndUpdateArticle(article);
		logger.debug("article update :: "+article2);
		return "redirect:/board/article?articleId="+article2.getArticleId();
	}

	@DeleteMapping("/article")
	public String articleDelete(@RequestParam(name = "articleId", defaultValue = "0") Long idx) {
		logger.debug("DELETE /board/article params: articleId="+idx);
		articleService.deleteArticle(idx);
		return "redirect:/board/article/list";
	}
	
	@PostMapping("/article/imageUpload2")
	@ResponseBody
	public String imageUpload(MultipartHttpServletRequest request) {
//		Map<String, MultipartFile> files = request.getFileMap();
		MultipartFile uploadFile = request.getFile("upload");
//		String path = "D:\\git\\Spring-bbs\\spring-repository\\article\\file";
		String path = "D:\\git\\Spring-bbs\\spring-bbs\\src\\main\\resources\\static\\repository\\bbs\\article\\file";
		String filename = String.valueOf(System.currentTimeMillis())+uploadFile.getOriginalFilename();
		try (FileOutputStream fos = new FileOutputStream(path + "\\" + filename);) {
			fos.write(uploadFile.getBytes());
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "/bbs/article/file/"+filename;
	}
}
