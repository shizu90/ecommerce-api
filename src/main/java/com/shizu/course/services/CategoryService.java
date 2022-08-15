package com.shizu.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shizu.course.entities.CategoryEntity;
import com.shizu.course.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepo;
	
	public List<CategoryEntity> findAll() {
		return categoryRepo.findAll();
	}
	
	public CategoryEntity findById(Long id) {
		Optional<CategoryEntity> obj = categoryRepo.findById(id);
		return obj.get();
	}
}
