package com.cjhm.bbs.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.cjhm.bbs.domain.Board;
import com.cjhm.bbs.domain.User;
import com.cjhm.bbs.repository.UserRepository;
import com.cjhm.bbs.service.BBSService;

@Controller
public class BBSController {

	@Autowired
	BBSService bbsService;

	@Autowired
	UserRepository userRepository;
	
	Logger logger = LoggerFactory.getLogger(BBSController.class);


	@GetMapping({ "", "/bbs" })
	public String bbs(@RequestParam(name = "idx", defaultValue = "0") Long idx, Model model) {
		Board bbs = bbsService.findBbsByIdx(idx);
//		System.out.println(idx+" / "+bbs2);
		model.addAttribute("bbs", bbs);
		return "bbs/view";
	}

	@GetMapping("/bbs/list")
	public String bbsList(@PageableDefault Pageable pageable, Model model) {
		Page<Board> bbsList = bbsService.findBbsList(pageable);
		model.addAttribute("bbsList", bbsList);
		return "bbs/list";
	}

	@PostMapping("/bbs")
	public String bbsInsert(Board bbs) {
		User u = userRepository.getOne(1L);
		bbs.setUser(u);
		
		Board b = bbsService.saveAndUpdateBbs(bbs);
		logger.info("bbs insert :: "+b);
		return "redirect:/bbs?idx="+b.getIdx();
	}
	
	@PutMapping("/bbs")
	public String bbsUpdate(Board bbs) {
		Board b = bbsService.saveAndUpdateBbs(bbs);
		logger.info("bbs update :: "+b);
		return "redirect:/bbs?idx="+b.getIdx();
	}

	@DeleteMapping("/bbs")
	public String bbsDelete(Board bbs) {
		logger.info("bbs delete :: "+bbs);
		bbsService.deleteBbs(bbs);
		return "redirect:/bbs/list";
	}
}
