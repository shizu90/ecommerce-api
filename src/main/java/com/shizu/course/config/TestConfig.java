package com.shizu.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.shizu.course.entities.CategoryEntity;
import com.shizu.course.entities.OrderEntity;
import com.shizu.course.entities.OrderItemEntity;
import com.shizu.course.entities.ProductEntity;
import com.shizu.course.entities.UserEntity;
import com.shizu.course.entities.enums.OrderStatus;
import com.shizu.course.repositories.CategoryRepository;
import com.shizu.course.repositories.OrderItemRepository;
import com.shizu.course.repositories.OrderRepository;
import com.shizu.course.repositories.ProductRepository;
import com.shizu.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private OrderItemRepository orderItemRepo;
	
	@Override
	public void run(String... args) throws Exception {
		UserEntity u1 = new UserEntity(null, "Maria Brown", "maria@gmail.com", "9888888", "123456");
		UserEntity u2 = new UserEntity(null, "Alex Gray", "alex@gmail.com", "966666", "1234567");
		
		CategoryEntity c1 = new CategoryEntity(null, "Electronics");
		CategoryEntity c2 = new CategoryEntity(null, "Computers");		
		
		categoryRepo.saveAll(Arrays.asList(c1, c2));
		
		ProductEntity p1 = new ProductEntity(null, "PC GAMER", "aKOKFODOKFODASF", 4300.50, "");
		ProductEntity p2 = new ProductEntity(null, "CELULAR", "aKOKFODOKFODASF", 2300.50, "");
		p1.getCategories().add(c2);
		
		OrderEntity o1 = new OrderEntity(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.CANCELED);
		OrderEntity o2 = new OrderEntity(null, Instant.parse("2019-06-20T19:53:07Z"), u2, OrderStatus.PAID);
		OrderEntity o3 = new OrderEntity(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.WAITING_PAYMENT);
		userRepo.saveAll(Arrays.asList(u1, u2));
		orderRepo.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItemEntity oi1 = new OrderItemEntity(o1, p1, 2, p1.getPrice());
		OrderItemEntity oi2 = new OrderItemEntity(o2, p2, 3, p2.getPrice());
		productRepo.saveAll(Arrays.asList(p1, p2));
		orderItemRepo.saveAll(Arrays.asList(oi1, oi2));
	}
	
}
