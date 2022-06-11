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
import javax.persistence.Table;

import com.example.demo.ServiceExterne.AdapterDlmsOperation;
import com.google.gson.annotations.JsonAdapter;

@Entity
@Table(name="metering_dlms_transaction")
public class DlmsTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="operation")
		private OperationTypes operation;
	@Column(name="Ordre")
		private int ordre;
	//valide
	@Column(name="stop_on_failure")
		private boolean stop_on_failure;
	@ManyToOne(targetEntity=Association.class)
		private Association association;
	@OneToMany(cascade=CascadeType.ALL)
	@JsonAdapter(AdapterDlmsOperation.class)
		private	List<DlmsOperation> dlms;
	@ManyToOne(targetEntity=Profil.class,cascade=CascadeType.ALL)
	@JoinColumn(name="profil")
		private Profil profil;
	public DlmsTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DlmsTransaction(int id, OperationTypes operation, int ordre, boolean stop_on_failure, Association association,
		 List<DlmsOperation> dlms) {
		super();
		this.id = id;
		this.operation = operation;
		this.ordre = ordre;
		this.stop_on_failure = stop_on_failure;
		this.association = association;
		this.dlms = dlms;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public OperationTypes getOperation() {
		return operation;
	}
	public void setOperation(OperationTypes operation) {
		this.operation = operation;
	}
	public int getOrdre() {
		return ordre;
	}
	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}
	public boolean isStop_on_failure() {
		return stop_on_failure;
	}
	public void setStop_on_failure(boolean stop_on_failure) {
		this.stop_on_failure = stop_on_failure;
	}
	public Association getAssociation() {
		return association;
	}
	public void setAssociation(Association association) {
		this.association = association;
	}

	public List<DlmsOperation> getDlms() {
		return dlms;
	}
	public void setDlms(List<DlmsOperation> dlms) {
		this.dlms = dlms;
	}
	public Profil getProfil() {
		return profil;
	}
	public void setProfil(Profil profil) {
		this.profil = profil;
	}

}
