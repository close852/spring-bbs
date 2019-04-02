package com.cjhm.bbs.controller;

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

import com.cjhm.bbs.domain.Board;
import com.cjhm.bbs.domain.User;
import com.cjhm.bbs.repository.UserRepository;
import com.cjhm.bbs.service.BBSService;

@Controller
@RequestMapping("/bbs")
public class BBSController {

	@Autowired
	BBSService bbsService;

	@Autowired
	UserRepository userRepository;

	@GetMapping({ "", "/" })
	public String bbs(@RequestParam(name = "idx", defaultValue = "0") Long idx, Model model) {
		Board bbs = bbsService.findBbsByIdx(idx);
//		System.out.println(idx+" / "+bbs2);
		model.addAttribute("bbs", bbs);
		return "bbs/view";
	}

	@GetMapping("/list")
	public String bbsList(@PageableDefault Pageable pageable, Model model) {
		Page<Board> bbsList = bbsService.findBbsList(pageable);
		model.addAttribute("bbsList", bbsList);
		return "bbs/list";
	}

	@PostMapping("/insert")
	public String bbsInsert(Board bbs) {
		User u = userRepository.getOne(1L);
		bbs.setUser(u);
		System.out.println("bbs insert :: "+bbs);
		Board b = bbsService.saveAndUpdateBbs(bbs);
		return "redirect:/bbs?idx="+b.getIdx();
	}
	
	@PutMapping("/update")
	public String bbsUpdate(Board bbs) {
		System.out.println("bbs2 ::"+ bbs);
		Board b = bbsService.saveAndUpdateBbs(bbs);
		return "redirect:/bbs?idx="+b.getIdx();
	}

	@DeleteMapping("/delete")
	public String bbsDelete(Board bbs) {
		bbsService.deleteBbs(bbs);
		return "redirect:/bbs/list";
	}
}
