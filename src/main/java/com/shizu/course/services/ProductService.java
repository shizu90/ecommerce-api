package com.shizu.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shizu.course.entities.ProductEntity;
import com.shizu.course.repositories.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository ProductRepo;

	public List<ProductEntity> findAll() {
		return ProductRepo.findAll();
	}
	
	public ProductEntity findById(Long id) {
		Optional<ProductEntity> obj = ProductRepo.findById(id);
		return obj.get();
	}
}
