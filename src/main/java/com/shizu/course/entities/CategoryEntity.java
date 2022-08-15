package com.shizu.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class CategoryEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Transient
	private Set<ProductEntity> products = new HashSet<>();
	public CategoryEntity() {}
	public CategoryEntity(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Long getId() {return this.id;}
	public void setId(Long id) {this.id = id;}
	
	public String getName() {return this.name;}
	public void setName(String name) {this.name = name;}
	
	public Set<ProductEntity> getProducts() {return this.products;}
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
		CategoryEntity other = (CategoryEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
