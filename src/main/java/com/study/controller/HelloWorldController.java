package com.study.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	private Logger log = Logger.getLogger(HelloWorldController.class);

	@RequestMapping("/hello")
	public String helloWorld(Model model) {
		String message = "Hello World, Spring 3.0!";
		System.out.println(message);
		model.addAttribute("message", message);
		log.info(message);
		return "hello";
	}

}