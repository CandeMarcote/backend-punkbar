package com.cande.punkbar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cande.punkbar.dao.OrderRepository;
import com.cande.punkbar.entity.Order;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;
	
	@Autowired
	public OrderServiceImpl(OrderRepository theOrderRepository) {
		orderRepository = theOrderRepository;
	}
	
	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Order findById(int theId) {
		Optional<Order> result = orderRepository.findById(theId);
		
		Order theOrder = null;
		if(result.isPresent()) {
			theOrder = result.get();
		}
		else {
			throw new RuntimeException("The order id was not found");
		}
		
		return theOrder;
	}

	@Override
	public void save(Order theOrder) {
		orderRepository.save(theOrder);
	}

	@Override
	public void deleteById(int theId) {
		orderRepository.deleteById(theId);
	}

}