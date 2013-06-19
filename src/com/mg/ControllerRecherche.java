package com.mg;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/recherche")

public class ControllerRecherche extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public static final String VUE = "/WEB-INF/menu.jsp";
	public static final String CHAMP_SEXE = "sexe";
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

		Service service = new Service();
		
		String sexe = "";
		request.setAttribute( "sexe", sexe);
		String pseudo = "";
		request.setAttribute( "pseudo", pseudo);
		String age = "";
		request.setAttribute( "age", age);
		String prenom ="";
		request.setAttribute( "prenom", prenom);
		String nom = "";
		request.setAttribute( "nom", nom);
		String mail = "";
		request.setAttribute( "mail", mail);
		String interet = "";
		request.setAttribute( "interet", interet);
		
		Interet obinteret = null;
		ArrayList<Interet> interets = null;
		ArrayList<User> users = null;
		
		try {
			obinteret = service.getInteret(interet);
			request.setAttribute( "obinteret", obinteret);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			interets = service.getListeInteret();
			request.setAttribute( "interets", interets);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			users = service.getListeUser(sexe, age, pseudo, prenom, nom, mail, interet);
			request.setAttribute( "users", users);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		service.deconnexion();
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		Service service = new Service();
		
		String sexe = request.getParameter("sexe");
		request.setAttribute( "sexe", sexe);
		String pseudo = request.getParameter("pseudo");
		request.setAttribute( "pseudo", pseudo);
		String age = request.getParameter("age");
		request.setAttribute( "age", age);
		String prenom = request.getParameter("prenom");
		request.setAttribute( "prenom", prenom);
		String nom = request.getParameter("nom");
		request.setAttribute( "nom", nom);
		String mail = request.getParameter("mail");
		request.setAttribute( "mail", mail);
		String interet = request.getParameter("interet");
		request.setAttribute( "interet", interet);
		
		if(sexe==null)sexe="";
		if(age==null)age="";
		if(pseudo==null)pseudo="";
		if(prenom==null)prenom="";
		if(nom==null)nom="";
		if(mail==null)mail="";
		if(interet==null)interet="";
		
		try {
			Interet obinteret = service.getInteret(interet);
			request.setAttribute( "obinteret", obinteret);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ArrayList<Interet> interets = service.getListeInteret();
			request.setAttribute( "interets", interets);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ArrayList<User> users = service.getListeUser(sexe, age, pseudo, prenom, nom, mail, interet);
			request.setAttribute( "users", users);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		service.deconnexion();
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request,response);
	}
}
