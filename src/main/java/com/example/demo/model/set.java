package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class set {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String setm;
	private String setd;
	public set() {
		super();
		// TODO Auto-generated constructor stub
	}
	public set(int id, String setm, String setd) {
		super();
		this.id = id;
		this.setm = setm;
		this.setd = setd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSetm() {
		return setm;
	}
	public void setSetm(String setm) {
		this.setm = setm;
	}
	public String getSetd() {
		return setd;
	}
	public void setSetd(String setd) {
		this.setd = setd;
	}
	
}
