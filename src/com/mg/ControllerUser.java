package com.mg;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/user")

public class ControllerUser extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public static final String VUE = "/WEB-INF/user.jsp";
	public static final String CHAMP_SEXE = "sexe";
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		Service service = new Service();
		
		String id = request.getParameter("id");
		request.setAttribute( "id", id);
		String type = "1";
		
		try {
			User user = Service.getUser(id);
			request.setAttribute( "user", user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			service.insertConsultation(id, type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ArrayList<String> consultation = service.getConsultation(id);
			request.setAttribute( "consultation", consultation);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		service.deconnexion();
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		Service service = new Service();
		
		String id = request.getParameter("id");
		request.setAttribute( "id", id);
		String type = "2";
			
		try {
			User user = Service.getUser(id);
			request.setAttribute( "user", user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			service.insertConsultation(id, type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ArrayList<String> consultation = service.getConsultation(id);
			request.setAttribute( "consultation", consultation);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		service.deconnexion();
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request,response);
	}
}
