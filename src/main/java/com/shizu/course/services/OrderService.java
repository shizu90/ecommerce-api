package com.shizu.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shizu.course.entities.OrderEntity;
import com.shizu.course.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepo;
	
	public List<OrderEntity> findAll() {
		return orderRepo.findAll();
	}
	
	public OrderEntity findById(Long id) {
		Optional<OrderEntity> obj = orderRepo.findById(id);
		return obj.get();
	}
}
