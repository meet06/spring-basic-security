package com.oldauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oldauth.models.User;
import com.oldauth.service.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	UserService service;
	
	@GetMapping("/user")
	public List<User> index()
	{
		return service.getUserList();
	}
	
	@GetMapping("/user/{username}")
	public User index2(@PathVariable("username") String username)
	{
		return service.getSingleUser(username);
	}
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user)
	{
		System.out.println("run");
		System.out.println(user);
		return service.addUser(user);
	}
	
	@GetMapping("/three")
	public String index3()
	{
		return "Welcome three Controller";
	}
}

