package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class get {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String getm;
	private String getd;
	public get() {
		super();
		// TODO Auto-generated constructor stub
	}
	public get(int id, String getm, String getd) {
		super();
		this.id = id;
		this.getm = getm;
		this.getd = getd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGetm() {
		return getm;
	}
	public void setGetm(String getm) {
		this.getm = getm;
	}
	public String getGetd() {
		return getd;
	}
	public void setGetd(String getd) {
		this.getd = getd;
	}
	
}
