package com.shizu.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.shizu.course.entities.UserEntity;
import com.shizu.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public void run(String... args) throws Exception {
		UserEntity u1 = new UserEntity(null, "Maria Brown", "maria@gmail.com", "9888888", "123456");
		UserEntity u2 = new UserEntity(null, "Alex Gray", "alex@gmail.com", "966666", "1234567");
		
		userRepo.saveAll(Arrays.asList(u1, u2));
	}
	
}
