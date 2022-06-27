package com.cande.punkbar.service;

import java.util.List;
import java.util.Optional;

import com.cande.punkbar.entity.CartItem;

public interface CartItemService {

	public void saveOrUpdate(CartItem theCartItem);
	
	public void deleteById(int theId);
	
	public void deleteAll();
	
	public List<CartItem> findAll();
	
	public Optional<CartItem> findByProductNumberAndCategory(int theProductNumber, String theCategory);
}
