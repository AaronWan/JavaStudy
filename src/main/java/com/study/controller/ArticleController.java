package com.study.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/article")
public class ArticleController {
	private Logger log = Logger.getLogger(ArticleController.class);

	@RequestMapping("/{type}")
	public String getArticleByType(Model model) {
		String message = "Hello World, Spring 3.0!";
		System.out.println(message);
		model.addAttribute("message", message);
		log.info(message);
		return "hello";
	}
	
	@RequestMapping("/{id}")
	public String getArticleById(Model model) {
		String message = "Hello World, Spring 3.0!";
		System.out.println(message);
		model.addAttribute("message", message);
		log.info(message);
		return "hello";
	}

	@RequestMapping("/{name}")
	public String getArticleByName(Model model) {
		String message = "Hello World, Spring 3.0!";
		System.out.println(message);
		model.addAttribute("message", message);
		log.info(message);
		return "hello";
	}
	
	@RequestMapping("/{tags}")
	public String getArticleByTags(Model model) {
		String message = "Hello World, Spring 3.0!";
		System.out.println(message);
		model.addAttribute("message", message);
		log.info(message);
		return "hello";
	}
}