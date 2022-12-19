package com.oldauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/user")
	public String getUser()
	{
		return "Get First User";
	}
	
	@GetMapping("/userList")
	public String getUserList()
	{
		return "Get First User";
	}
	
	@GetMapping("/userAdmin")
	public String getUserAdmin()
	{
		return "getAdmin";
	}
	
}
