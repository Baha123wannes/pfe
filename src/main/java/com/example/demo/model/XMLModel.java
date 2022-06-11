package com.example.demo.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
public class XMLModel {
	Profil profil ;

	
	public XMLModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public XMLModel(Profil profil) {
		super();
		this.profil = profil;
	}

	@XmlElement(name = "profil")
	public Profil getProfil() {
		return profil;
	}


	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	
	
}
