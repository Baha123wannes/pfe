package com.example.demo.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="metering_association")
public class Association {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Column(name="name")
		private String association;
	
		@OneToMany(cascade=CascadeType.ALL)
		private List<DlmsTransaction> transaction;
		public Association() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Association(int id, String name) {
			super();
			this.id = id;
			this.association = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return association;
		}
		public void setName(String name) {
			this.association = name;
		}
		public String getAssociation() {
			return association;
		}
		public void setAssociation(String association) {
			this.association = association;
		}
		public List<DlmsTransaction> getTransaction() {
			return transaction;
		}
		public void setTransaction(List<DlmsTransaction> transaction) {
			this.transaction = transaction;
		}
		
		
}
