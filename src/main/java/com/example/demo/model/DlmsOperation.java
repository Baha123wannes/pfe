package com.example.demo.model;

 
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.Model.*;
import com.example.demo.model.OperationTyp;

@Entity
@Table(name="metering_operation")
public class DlmsOperation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="operation_name")
	private String operation;
	@Column(name="operation_order")
	private int operation_order;
	@Column(name="pay_load")
	private String Pay_load;
	@Column(name="rel_date")
	private String Rel_date;
	@Column(name="begin_operation")
	private String begin_operation;
	@Column(name="end_operation")
	private String end_operation;
	@Column(name="Association")
	private String association;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="dlms_transaction_id")
	private DlmsTransaction transcation;
	@ManyToOne(cascade=CascadeType.ALL)
	private Cosem cosem;
	@OneToOne(cascade=CascadeType.ALL)
	private DlmsMethode dlmsMethod;
	@OneToOne(cascade=CascadeType.ALL)
	private DlmsAttribut dlmsAttribut;
	public DlmsOperation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DlmsOperation(int id, String operation, int operation_order, String pay_load, String rel_date,
			String begin_operation, String end_operation, String association,
			DlmsTransaction transcation, Cosem cosem, DlmsMethode dlmsMethod, DlmsAttribut dlmsAttribut) {
		super();
		this.id = id;
		this.operation = operation;
		this.operation_order = operation_order;
		Pay_load = pay_load;
		Rel_date = rel_date;
		this.begin_operation = begin_operation;
		this.end_operation = end_operation;
		this.association = association;

		this.transcation = transcation;
		this.cosem = cosem;
		this.dlmsMethod = dlmsMethod;
		this.dlmsAttribut = dlmsAttribut;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public int getOperation_order() {
		return operation_order;
	}
	public void setOperation_order(int operation_order) {
		this.operation_order = operation_order;
	}
	public String getPay_load() {
		return Pay_load;
	}
	public void setPay_load(String pay_load) {
		Pay_load = pay_load;
	}
	public String getRel_date() {
		return Rel_date;
	}
	public void setRel_date(String rel_date) {
		Rel_date = rel_date;
	}
	public String getBegin_operation() {
		return begin_operation;
	}
	public void setBegin_operation(String begin_operation) {
		this.begin_operation = begin_operation;
	}
	public String getEnd_operation() {
		return end_operation;
	}
	public void setEnd_operation(String end_operation) {
		this.end_operation = end_operation;
	}
	public String getAssociation() {
		return association;
	}
	public void setAssociation(String association) {
		this.association = association;
	}

	public DlmsTransaction getTranscation() {
		return transcation;
	}
	public void setTranscation(DlmsTransaction transcation) {
		this.transcation = transcation;
	}
	public Cosem getCosem() {
		return cosem;
	}
	public void setCosem(Cosem cosem) {
		this.cosem = cosem;
	}
	public DlmsMethode getDlmsMethod() {
		return dlmsMethod;
	}
	public void setDlmsMethod(DlmsMethode dlmsMethode) {
		this.dlmsMethod = dlmsMethode;
	}
	public DlmsAttribut getDlmsAttribut() {
		return dlmsAttribut;
	}
	public void setDlmsAttribut(DlmsAttribut dlmsAttribut) {
		this.dlmsAttribut = dlmsAttribut;
	}
	
	
}
