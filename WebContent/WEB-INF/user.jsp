<%@ page import="java.util.*" %>
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
		User user = (User) request.getAttribute("user");
		String couleur=user.getCouleurSexe();
		@SuppressWarnings("unchecked")
		ArrayList<String> consultation = (ArrayList<String>) request.getAttribute("consultation");
		%>
		<table>
			<tr>
				<td></td>
				<% out.println("<td><strong>Ce profil a été consulté : <b class=\"orange\">"+consultation.get(0)+"</b>  fois</strong></td>"); %>
			</tr>
			<tr>
				<td></td>
				<% out.println("<td><strong>Ce profil a été aimé : <b class=\"orange\">"+consultation.get(1)+"</b>  fois</strong></td>"); %>
			</tr>
			<tr>
				<td><table>
					<tr>
					<% out.println("<td><img style=\"width : 150px; height:150px;\" src=\"CSS/img/"+user.getAvatar()+".png\" alt=\"Avatar\"/></td>"); %>
					</tr>
					<tr style="height:56px;">
						<td>
							<form action="/MeetGeek/user?id=<% out.println(user.getId()); %>" method="post">
								<input type="submit" value="Aimer"/>
							</form>
						</td>
					</tr>
				</table></td>
				<td>
					<table>
						<%								
						out.println("<tr class=\""+couleur+"_fiche\"><td class=\"td_user\">Pseudo :</td>");
						out.println("<td class=\"td_fiche\">"+user.getPseudo()+"</td></tr>");
						out.println("<tr class=\""+couleur+"_fiche\"><td class=\"td_user\">Age :</td>");
						out.println("<td class=\"td_fiche\">"+user.getAge()+"</td></tr>");
						out.println("<tr class=\""+couleur+"_fiche\"><td class=\"td_user\">Prénom :</td>");
						out.println("<td class=\"td_fiche\">"+user.getPrenom()+"</td></tr>");
						out.println("<tr class=\""+couleur+"_fiche\"><td class=\"td_user\">Nom :</td>");
						out.println("<td class=\"td_fiche\">"+user.getNom()+"</td></tr>");
						out.println("<tr class=\""+couleur+"_fiche\"><td class=\"td_user\">Mail :</td>");
						out.println("<td class=\"td_fiche\">"+user.getMail()+"</td></tr>");
						out.println("<tr class=\""+couleur+"_fiche\"><td class=\"td_user\">Intérêts :</td>");
						out.println("<td class=\"td_interet\">");
						
						out.println(user.afficherInterets());
						%>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>