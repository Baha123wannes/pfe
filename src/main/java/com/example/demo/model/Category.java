package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="metering_profile_category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="authority")
	private String Authority;
	
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Category(int id, String name, String description, String authority) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		Authority = authority;

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthority() {
		return Authority;
	}
	public void setAuthority(String authority) {
		Authority = authority;
	}

	
}
