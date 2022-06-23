package com.cande.punkbar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cande.punkbar.dao.OrderItemRepository;
import com.cande.punkbar.entity.OrderItem;

@Service
public class OrderItemServiceImpl {

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	public void addOrderedProducts(OrderItem orderItem) {
		orderItemRepository.save(orderItem);
	}
}
