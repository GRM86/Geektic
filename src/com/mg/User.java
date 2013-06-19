package com.mg;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User {
	@Id
	private String id;
	private String age;
	private String nom;
	private String prenom;
	private String pseudo;
	private String mail;
	private String sexe;
	private String couleursexe;
	private String avatar;
	@ManyToMany(mappedBy = "Interet")
	private ArrayList<Interet> interets = new ArrayList<Interet>();
	private Integer nbinterets = 0;
		
	//CONSTRUCTEUR
	public User(String id,String age,String nom,String prenom,String pseudo,String mail,String sexe,String avatar){
		this.id=id;
		this.age=age;
		this.nom=nom;
		this.prenom=prenom;
		this.pseudo=pseudo;
		this.mail=mail;
		this.sexe=sexe;
		this.avatar=avatar;
		
		setCouleurSexe();
	}
	
	//GET
	public String getId(){
		return this.id;
	}
	public String getAge(){
		return this.age;
	}
	public String getNom(){
		return this.nom;
	}
	public String getPrenom(){
		return this.prenom;
	}
	public String getPseudo(){
		return this.pseudo;
	}
	public String getMail(){
		return this.mail;
	}
	public String getSexe(){
		return this.sexe;
	}
	public String getCouleurSexe(){
		return this.couleursexe;
	}
	public String getAvatar(){
		return this.avatar;
	}
	public ArrayList<Interet> getInterets(){
		return this.interets;
	}
	public Integer getNbInterets(){
		return this.nbinterets;
	}
	
	//SET
	public void setInterets(Interet interet){
		this.interets.add(interet);
		this.nbinterets++;
	}
	public void setCouleurSexe(){
		if("H".equals(this.sexe)){
			couleursexe = "tr_homme";
		}else{
			couleursexe = "tr_femme";
		}
	}
	
	//AFFICHE
	public String afficherInterets(){
		String txt="";
		if(this.interets.size()>3) txt=txt+"<div style=\"overflow-y:scroll;width: 100%; height: 63px;\">";
		for (Integer i=0; i < this.interets.size();i++){
			 txt=txt+this.interets.get(i).getLibelle()+"<br />";
		}
		if(this.interets.size()>3)  txt=txt+"</div>";
		 txt=txt+"</td></tr>";
		return txt;
	}
}
