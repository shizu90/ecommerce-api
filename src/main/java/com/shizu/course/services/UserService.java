package com.shizu.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shizu.course.entities.UserEntity;
import com.shizu.course.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;

	public List<UserEntity> findAll() {
		return userRepo.findAll();
	}
	
	public UserEntity findById(Long id) {
		Optional<UserEntity> obj = userRepo.findById(id);
		return obj.get();
	}
	
	public UserEntity insert(UserEntity obj) {
		return userRepo.save(obj);
	}
	
	public void delete(Long id) {
		userRepo.deleteById(id);
	}
}
