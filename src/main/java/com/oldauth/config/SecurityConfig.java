package com.oldauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.oldauth.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/home/**").hasRole("EMPLOYEE")
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/public/**").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("amit").password("amt").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("swati").password("swa").roles("EMPLOYEE");
		
		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
	}
	
	/*
		AbstractPasswordEncoder, 
		Argon2PasswordEncoder, 
		BCryptPasswordEncoder, 
		DelegatingPasswordEncoder, 
		LdapShaPasswordEncoder, 
		Md4PasswordEncoder, 
		MessageDigestPasswordEncoder, 
		NoOpPasswordEncoder, 
		Pbkdf2PasswordEncoder, 
		SCryptPasswordEncoder, 
		StandardPasswordEncoder
	*/
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
}

