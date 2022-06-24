package com.cande.punkbar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@JoinTable(name="cart")
	private int cartId;
	
	@Column(name="product_number")
	private int productNumber;
	
	@Column(name="category")
	private String category;
	
	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Column(name="user_id")
	private int userId;
	
	@Column(name="amount")
	private int amount;
	
	//define constructors
	public Order() {}


	public Order(int productNumber, String category, int cartId, int userId, int amount) {
		this.productNumber = productNumber;
		this.category = category;
		this.cartId = cartId;
		this.userId = userId;
		this.amount = amount;
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


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", productNumber=" + productNumber + ", category=" + category + ", cartId=" + cartId
				+ ", userId=" + userId + ", amount=" + amount + "]";
	}
}
