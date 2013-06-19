package com.mg;

import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Service {
	
	private DAO dao;
	
	public Service() {
		try {
			this.dao = new DAO();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//DECONNEXION
	
	public void deconnexion(){
		this.dao.deconnexion();
	}
	
	//T_AUDIT
	
	public ArrayList<String> getConsultation(String id) throws UnknownHostException, SQLException{
		ArrayList<String> nbvisite=dao.getConsultation(id);
		return nbvisite;
	}
	
	public void insertConsultation(String id, String type) throws UnknownHostException, SQLException{
		dao.insertConsultation(id, type);
	}
	
	//T_USER
	
	public User getUser(String id) throws SQLException{
		User user=dao.getUser(id);
		return user;
	}
	
	public ArrayList<User> getListeUser(String sexe,String age, String pseudo, String prenom, String nom, String mail,String interet) throws SQLException{
		ArrayList<User> users=dao.getListeUser(sexe, age, pseudo, prenom, nom, mail, interet);
		return users;
	}
	
	//T_INTERET
	
	public Interet getInteret(String id) throws SQLException{
		Interet interet = dao.getInteret(id);
		return interet;
	}	

	public ArrayList<Interet> getListeInteret() throws SQLException{
		ArrayList<Interet> interets = dao.getListeInteret();
		return interets;
	}
}
