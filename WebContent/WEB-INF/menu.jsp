<%@page import="java.sql.Statement"%>
<%@ page import="java.util.List, java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.*" %>
<%@ page import="org.hsqldb.*" %>
<%@ page import="com.mg.*" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Geektic</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="CSS/css/style.css" />
	</head>
	<body>
	<% 	
	//VARIABLES POST
	String sexe = (String) request.getAttribute("sexe");
	String pseudo = (String) request.getAttribute("pseudo");
	String age = (String) request.getAttribute("age");
	String prenom = (String) request.getAttribute("prenom");
	String nom = (String) request.getAttribute("nom");
	String mail = (String) request.getAttribute("mail");
	String interet = (String) request.getAttribute("interet");
	Interet obinteret = (Interet) request.getAttribute("obinteret");
	@SuppressWarnings("unchecked")
	ArrayList<Interet> interets = (ArrayList<Interet>) request.getAttribute("interets");
	@SuppressWarnings("unchecked")
	ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");
	%>
	<br />
		<div id="fond">
			<br />
				<h1>GEEKTIC</h1>
			<table class="table_first">
				<tr>
					<td class="td_first">
						<form action="/Geektic/recherche" method="post">
							<table class="table_second">
								<tr><td>
										<table class="table_title"><tr><td><b>RECHERCHER</b></td></tr></table>
								</td></tr>
								<tr><td>
									<table class="tableau">
										<tr>
											<td class="nom_recherche"><strong>Sexe :</strong></td>
											<td>
											<select name="sexe">
												<% if(sexe!="")out.println("<option value="+sexe+">"+sexe+"</option>"); %>
												<option value="">Tous</option>
												<option value="Femme">Femme</option>
												<option value="Homme">Homme</option>
											</select>
											</td>
										</tr>
										<tr>
											<td class="nom_recherche"><strong>Age :</strong></td>
											<td><input name="age" value="<% out.println(age); %>"></td>
											<td class="nom_recherche"><strong>Pseudo :</strong></td>
											<td><input name="pseudo" value="<% out.println(pseudo); %>"></td>
										</tr>
										<tr>
											<td class="nom_recherche"><strong>Prénom :</strong></td>
											<td><input name="prenom" value="<% out.println(prenom); %>"></td>
											<td class="nom_recherche"><strong>Nom :</strong></td>
											<td><input name="nom" value="<% out.println(nom); %>"></td>
										</tr>
										<tr>
											<td class="nom_recherche"><strong>Mail :</strong></td>
											<td><input name="mail" value="<% out.println(mail); %>"></td>
										</tr>
										<tr>
											<td class="nom_recherche"><strong>Intérêts :</strong></td>
											<td>
											<select name="interet">
												<%
												if(interet!="") out.println("<option value="+obinteret.getId()+">"+obinteret.getLibelle()+"</option>");
												out.println("<option value=\"\">Tous</option>");
												for (Integer i=0; i < interets.size();i++){
													out.println("<option value=\""+interets.get(i).getId()+"\">"+interets.get(i).getLibelle()+"</option>");
												}
												%>
											</select>
											</td>
										</tr>
									</table>
								</td></tr>
								<tr><td>
										<table class="table_title"><tr><td><input type="submit" value="valider"/></td></tr></table>
								</td></tr>
							</table>							
						</form>
					</td>
					<td class="td_first">
						<table class="table_second">
							<tr><td>
									<table class="table_title"><tr><td><b>UTILISATEURS</b></td></tr></table>
							</td></tr>
							<tr><td>
								<table class="tableau">
									<tr><td>
										<table class="table_entete"><tr class="tr_entete">
											<td class="td_entete"><b>Pseudo</b></td>
											<td class="td_entete"><b>Age</b></td>
											<td class="td_entete"><b>Prénom</b></td>
											<td class="td_entete"><b>Nom</b></td>		
											<td class="td_overflow"></td>
										</tr></table>
										<div style="overflow-y:scroll;width: 100%; height: 226px;">
										<table style="background-color:#FFFFFF;">
											<%
											Integer compte=0;
											String fiche="";
											
											for (Integer i=0; i < users.size();i++){
												fiche="<a href='/Geektic/user?id="+users.get(i).getId()+"' target=wclose onclick=window.open('aide.php?code=1','wclose','width=560,height=305,toolbar=no,status=no,left=300,top=100')>";

												out.println("<tr class=\""+users.get(i).getCouleurSexe()+"\">");
												out.println("<td class=\"td_user\">"+fiche+users.get(i).getPseudo()+"</td>");
												out.println("<td class=\"td_user\">"+fiche+users.get(i).getAge()+"</td>");
												out.println("<td class=\"td_user\">"+fiche+users.get(i).getPrenom()+"</td>");
												out.println("<td class=\"td_user\">"+fiche+users.get(i).getNom()+"</td>");
												out.println("</tr></a>");
												compte++;
											}

											while(compte<8){	
												out.println("<tr class=\"tr_vide\">");
												out.println("<td style=\"width:136px;\"></td><td style=\"width:136px;\"></td>");
												out.println("<td style=\"width:136px;\"></td><td style=\"width:136px;\"></td>");
												out.println("</tr>");
												compte++;
											}
											%>
										</table>			
										</div>
									</td></tr>
								</table>
							</td></tr>
							<tr><td>
									<table class="table_title"><tr><td></td></tr></table>
							</td></tr>
						</table>	
					</td>
				</tr>
			</table>
			<br />			
		</div>
	</body>
</html>