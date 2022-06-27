package com.cande.punkbar.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cande.punkbar.entity.Cart;
import com.cande.punkbar.entity.CartItem;
import com.cande.punkbar.service.CartItemService;
import com.cande.punkbar.service.CartService;
import com.cande.punkbar.service.UserService;

@RestController
@RequestMapping("/cartItems")
public class CartItemRestController {

	private CartItemService cartItemService;
	private CartService cartService;
	private UserService userService;
	
	public CartItemRestController (CartItemService theCartItemService, CartService theCartService, UserService theUserService) {
		cartItemService = theCartItemService;
		cartService = theCartService;
		userService = theUserService;
	}
	
	@GetMapping("/all")
	@CrossOrigin
	public List<CartItem> findAll() {
		List<CartItem> theCartItems = cartItemService.findAll();
		return theCartItems;
	}
	
	
	@PostMapping("/")
	@CrossOrigin
	public CartItem addCartItem(@RequestBody CartItem theCartItem, @RequestParam int userId) {
		
		Cart theCart = cartService.findByUserId(userId);
		cartService.save(theCart);
		//System.out.println(theCart);
		//System.out.println(theCart.getId());
		
		theCartItem.setId(0);
		theCartItem.setCartId(theCart.getId());
		//System.out.println("added");
		cartItemService.saveOrUpdate(theCartItem);
		return theCartItem;
	}
	
	@DeleteMapping("/")
	@CrossOrigin
	public String deleteCartItem(@RequestParam int cartItemId) {
		cartItemService.deleteById(cartItemId);
		return "deleted correctly";
	}
	
	@DeleteMapping("/deleteAll")
	@CrossOrigin
	public String deleteAll() {
		cartItemService.deleteAll();
		return "the cart is empty";
	}
	
	@PutMapping("/")
	@CrossOrigin
	public String updateCartItem(@RequestBody CartItem theCartItem) {
		CartItem existingCartItem = cartItemService.findByProductNumberAndCategory(theCartItem.getProductNumber(), theCartItem.getCategory());
		if(existingCartItem == null) {
			cartItemService.saveOrUpdate(theCartItem);
		}
		return "updated item";
	}
}
