package com.shizu.course.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.shizu.course.entities.OrderEntity;
import com.shizu.course.entities.ProductEntity;

@Embeddable
public class OrderItemPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderEntity order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity product;

	public OrderEntity getOrder() {return this.order;}
	public void setOrder(OrderEntity order) {this.order = order;}
	
	public ProductEntity getProduct() {return this.product;}
	public void setProduct(ProductEntity product) {this.product = product;}
	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
	
	
}
