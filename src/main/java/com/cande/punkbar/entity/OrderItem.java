package com.cande.punkbar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderItems")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderItemId;
	
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="product_number")
	private int productNumber;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="category")
	private String category;
	
	@ManyToOne
	@JoinColumn(name="order_id", referencedColumnName="id", insertable=false, updatable=false)
	private Order order;

	public OrderItem() {
	}

	public OrderItem(int orderId, int productNumber, int amount, String category, Order order) {
		this.orderId = orderId;
		this.productNumber = productNumber;
		this.amount = amount;
		this.category = category;
		this.order = order;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", productNumber=" + productNumber
				+ ", amount=" + amount + ", category=" + category + ", order=" + order + "]";
	}
	
	
}
