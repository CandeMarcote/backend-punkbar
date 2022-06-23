package com.cande.punkbar.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="product_number")
	private int productNumber;
	
	@Column(name="cart_id")
	private int userId;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="category")
	private String category;
	
	@OneToMany
	@JoinColumn(name="order_id")
	private List<OrderItem> orderItems;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Order() {
	}

	public Order(int productNumber, int userId, int amount, String category, List<OrderItem> orderItems, User user) {
		this.productNumber = productNumber;
		this.userId = userId;
		this.amount = amount;
		this.category = category;
		this.orderItems = orderItems;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", productNumber=" + productNumber + ", userId=" + userId + ", amount=" + amount
				+ ", category=" + category + ", orderItems=" + orderItems + ", user=" + user + "]";
	}

	
}
