package com.shizu.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.shizu.course.entities.UserEntity;
import com.shizu.course.repositories.UserRepository;
import com.shizu.course.services.exceptions.DatabaseException;
import com.shizu.course.services.exceptions.ResourceNotFoundException;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;

	public List<UserEntity> findAll() {
		return userRepo.findAll();
	}
	
	public UserEntity findById(Long id) {
		Optional<UserEntity> obj = userRepo.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public UserEntity insert(UserEntity obj) {
		return userRepo.save(obj);
	}
	
	public void delete(Long id) {
		try {
			userRepo.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public UserEntity update(Long id, UserEntity obj) {
		try {
			UserEntity entity = userRepo.getOne(id);
			updateData(entity, obj);
			return userRepo.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(UserEntity entity, UserEntity obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
