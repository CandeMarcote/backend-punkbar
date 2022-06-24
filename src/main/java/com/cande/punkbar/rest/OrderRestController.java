package com.cande.punkbar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cande.punkbar.entity.Cart;
import com.cande.punkbar.entity.Order;
import com.cande.punkbar.entity.User;
import com.cande.punkbar.service.CartService;
import com.cande.punkbar.service.OrderService;
import com.cande.punkbar.service.UserService;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

	private OrderService orderService;
	private CartService cartService;
	private UserService userService;
	
	@Autowired
	public OrderRestController(OrderService theOrderService, UserService theUserService, CartService theCartService) {
		orderService = theOrderService;
		userService = theUserService;
		cartService = theCartService;
	}
	
	@GetMapping(value="/")
	@CrossOrigin
	public List<Order> findAll() {
		return orderService.findAll();
	}
	
	@GetMapping(value="/{orderId}")
	@CrossOrigin
	public Order getOrder(@PathVariable int orderId) {
		Order theOrder = orderService.findById(orderId);
		
		if(theOrder == null) {
			throw new RuntimeException("Order id not found - " + orderId);
		}
		
		return theOrder;
	}
	
	@PostMapping("/place_order")
	@CrossOrigin
	public void addOrder(@RequestParam int userId, @RequestParam int cartId) {
		
		List<Cart> cartItems = cartService.findAll();
		
		for(int i = 0; i < cartItems.size(); i++) {
			Order theOrder = new Order();
			theOrder.setAmount(cartItems.get(i).getAmount());
			theOrder.setCategory(cartItems.get(i).getCategory());
			theOrder.setProductNumber(cartItems.get(i).getProductNumber());
			theOrder.setUserId(userId);
			theOrder.setCartId(cartId);
			
			orderService.save(theOrder);
		}
	}
	
	@DeleteMapping("/users/{userId}/order/{orderId}")
	@CrossOrigin
	public String deleteOrder(@PathVariable int orderId, @PathVariable int userId) {
		Order theOrder = orderService.findById(orderId);
		User theUser = userService.findById(userId);
		if(theOrder == null) {
			throw new RuntimeException("Order not found " + orderId);
		}
		
		orderService.deleteById(orderId);
		
		return "Order (id: " + orderId + ") deleted! user: " + theUser.getUsername() + " " + userId;
	}
}

