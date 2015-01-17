package com.study.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends BaseController{
	private Logger log = Logger.getLogger(IndexController.class);

	@RequestMapping("/index")
	public String index(Model model) {
		String message = "Hello World, Spring 3.0!";
		model.addAttribute("message", message);
		log.info(message);
		return "index";
	}

}