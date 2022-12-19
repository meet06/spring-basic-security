package com.oldauth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.oldauth.models.User;
import com.oldauth.repositories.UserRepository;

@Service
public class UserService {

	List<User> userList= new ArrayList<User>();
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService()
	{
		User user = new User();
		user.setUsername("amit");
		user.setEmail("amit@gmail.com");
		user.setPassword("Five$5doller");
		user.setRole("ROLE_EMPLOYEE");
		
		User user1 = new User();
		user1.setUsername("swati");
		user1.setEmail("swat@gmail.com");
		user1.setPassword("radhe");
		user1.setRole("ROLE_ADMIN");
		
//		this.userList =  List.of(user,user1);
//		System.out.println(this.userList.getClass().getName());
		userList.add(user1);
		userList.add(user);
		
	}
	
	public List<User> getUserList()
	{
		//return this.userList;
		return userRepository.findAll();
	}
	
	public User getSingleUser(String username)
	{
		return userRepository.findByUsername(username);
		//return userList.stream().filter(user->user.getUsername().equals(username)).findAny().orElse(null);
	}
	
	public User addUser(User user)
	{
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		User saveUser = userRepository.save(user);
		return saveUser;
//		this.userList.add(user);
//		return this.getSingleUser(user.getUsername());
	}
}
