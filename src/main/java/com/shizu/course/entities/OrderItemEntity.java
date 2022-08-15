package com.shizu.course.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.shizu.course.entities.pk.OrderItemPK;

@Entity
public class OrderItemEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrderItemPK id;
	private Integer quantity;
	private Double price;
	
	public OrderItemEntity() {}
	public OrderItemEntity(OrderEntity order, ProductEntity product, Integer quantity, Double price) {
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	
	public OrderEntity getOrder() {return this.id.getOrder();}
	public void setOrder(OrderEntity order) {this.id.setOrder(order);}
	
	public ProductEntity getProduct() {return this.id.getProduct();}
	public void setProduct(ProductEntity product) {this.id.setProduct(product);}
	
	public Integer getQuantity() {return this.quantity;}
	public void setQuantity(Integer quantity) {this.quantity = quantity;}
	
	public Double getPrice() {return this.price;}
	public void setPrice(Double price) {this.price = price;}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemEntity other = (OrderItemEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
