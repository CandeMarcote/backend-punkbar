package com.cande.punkbar.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cande.punkbar.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

	public Optional<CartItem> findByProductNumberAndCategory(int theProductNumber, String theCategory);
}
