package com.mg;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import org.springframework.stereotype.Repository;

@Repository
public class DAO2 {

	@PersistenceContext
	private EntityManager em;
	
	public User getUser(String id) throws SQLException{
		String query="SELECT * FROM T_USER WHERE ID='"+id+"'";
		return em.createQuery(query, User.class).getSingleResult();
	}
	
	public List<User> getListeUser(String sexe,String age, String pseudo, String prenom, String nom, String mail,String interet) throws SQLException{

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
		
		return em.createQuery(query,User.class).getResultList();
	}
	
	public List<User> findbyInterest(){
		return null;
	}
}