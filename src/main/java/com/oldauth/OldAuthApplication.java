package com.oldauth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.oldauth.models.User;
import com.oldauth.repositories.UserRepository;

@SpringBootApplication
public class OldAuthApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(OldAuthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername("amit");
		user.setEmail("amit@gmail.com");
		user.setPassword(bCryptPasswordEncoder.encode("Five$5doller"));
		user.setRole("ROLE_EMPLOYEE");
		
		User user1 = new User();
		user1.setUsername("swati");
		user1.setEmail("swat@gmail.com");
		user1.setPassword(bCryptPasswordEncoder.encode("radhe"));
		user1.setRole("ROLE_ADMIN");
		
		List<User> userList = List.of(user,user1);
		
		List<User> saveAll = userRepository.saveAll(userList);
		System.out.println(saveAll);
	}
	
}
