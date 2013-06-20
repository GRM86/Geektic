package com.mg;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class Interet {
	@Id
	private String id;
	private String libelle;
	@ManyToMany(mappedBy="interets")
	private ArrayList<User> users; 
	
	//CONSTRUCTEUR
	public Interet(String id,String libelle){
		this.id=id;
		this.libelle=libelle;
	}
	
	//GET
	public String getId(){
		return this.id;
	}
	public String getLibelle(){
		return this.libelle;
	}
}
