package com.oldauth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oldauth.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);

}
