package com.mg;

import java.sql.*;
import java.util.ArrayList;
import java.net.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class DAO {
	
	@PersistenceContext
	private EntityManager em;
	
	protected Statement  statement = null;
	protected Connection connexion = null;
	protected ResultSet resultat = null;
	  
	//CONNEXION DECONNEXION
	public DAO() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Class.forName("org.hsqldb.jdbcDriver").newInstance();
		connexion = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/Geektic", "sa",  "");
		statement = connexion.createStatement();
	}
	
	public void deconnexion(){
		try {
			connexion.close() ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//T_AUDIT
	
	public ArrayList<String> getConsultation(String id) throws UnknownHostException, SQLException{
		ArrayList<String> nbvisite = new ArrayList<String>();
		resultat = statement.executeQuery("SELECT count(IDUSER) AS NB FROM T_AUDIT WHERE IDUSER='"+id+"' AND TYPE='1'");
		resultat.next();
		nbvisite.add(resultat.getString("NB"));
		resultat = statement.executeQuery("SELECT count(IDUSER) AS NB FROM T_AUDIT WHERE IDUSER='"+id+"' AND TYPE='2'");
		resultat.next();
		nbvisite.add(resultat.getString("NB"));
		return nbvisite;
	}
	
	public void insertConsultation(String id, String type) throws UnknownHostException, SQLException{
		InetAddress Ip =InetAddress.getLocalHost();	
		statement.executeUpdate("INSERT INTO T_AUDIT (IDUSER,DATEHEURE,IPVISITEUR,TYPE) VALUES ('"+id+"',NOW(),'"+Ip.getHostAddress()+"','"+type+"')");
	}
	
	//T_USER
	
	public User getUser(String id) throws SQLException{
		User user=null;
		String query="SELECT * FROM T_USER WHERE ID='"+id+"'";
		resultat = statement.executeQuery(query);

		while(resultat.next()){		
			user = new User(resultat.getString("ID"),resultat.getString("AGE"),
							resultat.getString("NOM"),resultat.getString("PRENOM"),
							resultat.getString("PSEUDO"),resultat.getString("MAIL"),
							resultat.getString("SEXE"),resultat.getString("AVATAR"));
			String queryinteret="SELECT T_INTERET.LIBELLE,T_INTERET.ID FROM T_USERINTERET,T_INTERET WHERE T_USERINTERET.IDINTERET=T_INTERET.ID AND T_USERINTERET.IDUSER='"+id+"'";
			ResultSet resultatinteret = statement.executeQuery(queryinteret);
			resultatinteret.next();
			user.setInterets(new Interet(resultatinteret.getString("ID"),resultatinteret.getString("LIBELLE")));
		}
		return user;
	}
	
	public ArrayList<User> getListeUser(String sexe,String age, String pseudo, String prenom, String nom, String mail,String interet) throws SQLException{
		ArrayList<User> users = new ArrayList<User>();

		String query="SELECT * FROM T_USER";
		if(interet!="") query=query+",T_USERINTERET";
		query=query+" WHERE NOM LIKE '%"+nom+"%'";
		if(sexe!=""){
			query=query+" AND SEXE LIKE '%"+sexe.substring(0, 1)+"%'";
		}
		query=query+" AND PSEUDO LIKE '%"+pseudo+"%'";
		query=query+" AND AGE LIKE '%"+age+"%'";
		query=query+" AND PRENOM LIKE '%"+prenom+"%'";
		query=query+" AND MAIL LIKE '%"+mail+"%'";
		if(interet!="") query=query+" AND T_USERINTERET.IDUSER=T_USER.ID AND T_USERINTERET.IDINTERET='"+interet+"'";
		
		resultat = statement.executeQuery(query);
		
		while(resultat.next()){		
			users.add(new User(resultat.getString("ID"),resultat.getString("AGE"),
					resultat.getString("NOM"),resultat.getString("PRENOM"),
					resultat.getString("PSEUDO"),resultat.getString("MAIL"),
					resultat.getString("SEXE"),resultat.getString("AVATAR")));
		}
		return users;
	}
	
	//T_INTERET
	
	public Interet getInteret(String id) throws SQLException{
		Interet interet=null;
		String query ="";
		if(id!=""){
			query="SELECT * FROM T_INTERET WHERE ID='"+id+"'";
			resultat = statement.executeQuery(query);
			resultat.next();
			interet = new Interet(resultat.getString("ID"),resultat.getString("LIBELLE"));
		}
		return interet;
	}	

	public ArrayList<Interet> getListeInteret() throws SQLException{
		ArrayList<Interet> interets = new ArrayList<Interet>();

		resultat = statement.executeQuery("SELECT * FROM T_INTERET");
		while(resultat.next()){		
			interets.add(new Interet(resultat.getString("ID"),resultat.getString("LIBELLE")));
		}
		return interets;
	}
}


