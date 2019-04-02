package com.cjhm.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjhm.bbs.domain.Board;
import com.cjhm.bbs.service.BBSService;


@Controller
@RequestMapping("/bbs")
public class BBSController {

	@Autowired
	BBSService bbsService;
	
	@GetMapping({"","/"})
	public String bbs(@RequestParam(name="idx",defaultValue="1020") Long idx, Model model) {
		model.addAttribute("bbs", bbsService.findBbsByIdx(idx));
		return "bbs/view";
	}
	@GetMapping("/list")
	public String bbsList(@PageableDefault Pageable pageable,Model model) {
		Page<Board> bbsList = bbsService.findBbsList(pageable);
		model.addAttribute("bbsList", bbsList);
		return "bbs/list";
	}
}
