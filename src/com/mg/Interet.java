package com.mg;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Interet {
	@Id
	private String id;
	private String libelle;

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
