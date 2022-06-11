package com.example.demo.model;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.Model.DataModel;
import com.example.demo.ServiceExterne.AdpaterDlmsTransaction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.JsonAdapter;



@Entity
@Table(name="metering_profile")
public class Profil  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="description")
	private String description;
	@Column(name="Creation_date")
	private Date Creation_date;
	@Column(name="modification_date")
	private Date modification_date;
	@Column(name="name",nullable=false)
	private String name;
	@Column(name="user_name")
	private String user_name;
	@Column(name="TransactionFilePath")
	private String xmlns;
	@Column(name="Profile_type")
	private String Profile_type;
	@Column(name="Already_used")
	private boolean Already_used;
	@Column(name="category")
	private String category;
	@OneToOne(cascade=CascadeType.ALL)
	private Category categories;
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	private DataModel dataModel;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JsonAdapter(AdpaterDlmsTransaction.class)
	private List<DlmsTransaction> transactions;
	public Profil() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Profil (Profil p)
	{
		this.Already_used=p.Already_used;
		this.category=p.category;
		this.Creation_date=p.Creation_date;
		this.dataModel=p.dataModel;
		this.description=p.description;
		this.id=p.id;
		this.modification_date=p.modification_date;
		this.name=p.name;
		this.Profile_type=p.Profile_type;
		this.transactions=p.transactions;
		this.user_name=p.user_name;
		this.xmlns=p.xmlns;
	}
	public Profil(int id, String description, Date creation_date, Date modification_date, String name, String user_name,
			String xmlns, String profile_type, boolean already_used, String category, DataModel dataModel, List<DlmsTransaction> transaction) {
		super();
		this.id = id;
		this.description = description;
		Creation_date = creation_date;
		this.modification_date = modification_date;
		this.name = name;
		this.user_name = user_name;
		this.xmlns = xmlns;
		Profile_type = profile_type;
		Already_used = already_used;
		this.category = category;
		this.dataModel = dataModel;
		transactions = transaction;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreation_date() {
		return Creation_date;
	}
	public void setCreation_date(Date creation_date) {
		Creation_date = creation_date;
	}
	public Date getModification_date() {
		return modification_date;
	}
	public void setModification_date(Date modification_date) {
		this.modification_date = modification_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getXmlns() {
		return xmlns;
	}
	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}
	public String getProfile_type() {
		return Profile_type;
	}
	public void setProfile_type(String profile_type) {
		Profile_type = profile_type;
	}
	public boolean isAlready_used() {
		return Already_used;
	}
	public void setAlready_used(boolean already_used) {
		Already_used = already_used;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public DataModel getDataModel() {
		return dataModel;
	}
	public void setDataModel(DataModel dataModel) {
		this.dataModel = dataModel;
	}
	
	public List<DlmsTransaction> getTransaction() {
		return transactions;
	}
	public void setTransaction(List<DlmsTransaction> transaction) {
		transactions = transaction;
	}

}
