package com.cande.punkbar.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cande.punkbar.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	List<Order> findAllByUserId(Integer userId);
}
