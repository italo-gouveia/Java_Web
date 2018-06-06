package com.italo.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstSpringBootController {

	@RequestMapping("/")
	public String index() {
		return "index page";
	}
	
	@RequestMapping("/showtext")
	public String showText() {
		return "hello world!";
	}
}
