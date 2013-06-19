package com.test;

import static org.junit.Assert.*;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;

import com.mg.DAO;
import com.mg.Interet;
import com.mg.User;

public class DAOTest {
	
	@Test
	public void getInteretTest() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DAO dao = new DAO();
		Interet obinteret = dao.getInteret("1");
		assertEquals("JAVA", obinteret.getLibelle());
		assertEquals("1", obinteret.getId());
	}
	
	@Test
	public void getListeInteret() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DAO dao = new DAO();
		ArrayList<Interet> interets = dao.getListeInteret();
		assertEquals("CSS", interets.get(2).getLibelle());
		assertEquals("CS", interets.get(5).getLibelle());
		assertEquals("1", interets.get(0).getId());
		assertEquals("8", interets.get(7).getId());
	}
	
	@Test
	public void getInteretUser() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DAO dao = new DAO();
		User user = dao.getUser("12");
		assertEquals("Alex", user.getPrenom());
		assertEquals("12", user.getId());
	}
	
	@Test
	public void getListeUser() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DAO dao = new DAO();
		ArrayList<User> users = dao.getListeUser("","","","","","","");
		assertEquals("9", users.get(7).getAvatar());
		assertEquals("F", users.get(5).getSexe());
		assertEquals("Gabriel", users.get(0).getPrenom());
		assertEquals("14", users.get(13).getId());
	}
}
