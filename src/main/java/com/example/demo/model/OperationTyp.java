package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.Model.Cosem;

@Entity
@Table(name="OperationTy")
public class OperationTyp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="ordre")
	private int order;
	@OneToOne(cascade=CascadeType.ALL)
	private Cosem cosem;
	public OperationTyp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OperationTyp(int id, int ordre,  Cosem cosem) {
		super();
		this.id = id;
		this.order = ordre;
		this.cosem = cosem;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrdre() {
		return order;
	}
	public void setOrdre(int ordre) {
		this.order = ordre;
	}
	public Cosem getCosem() {
		return cosem;
	}
	public void setOperation_type(Cosem cosem) {
		this.cosem = cosem;
	}
	
}
