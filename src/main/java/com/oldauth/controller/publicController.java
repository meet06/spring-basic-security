package com.oldauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public")
public class publicController {

	@GetMapping("/")
	public String publicView()
	{
		return "First Web Page";
	}
	
	@GetMapping("/second")
	public String anotherPage()
	{
		return "Another Page";
	}
}
