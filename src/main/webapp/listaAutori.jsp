<%@page import="model.Autore"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <%@ include file ="menu.jsp" %>
</head>
<body>
 <a href="InsertAutore.jsp">Inserisci autore</a>
	<table>
	<tr> 
		<th>ID</th>	
		<th>Nome</th>
		<th>Cognome</th>
		<th>Nazionalità</th>	
	</tr>
 
	<%
 		List<Autore> lista = (List<Autore>) request.getAttribute("listaAutori");
		if(lista!=null){
			for(Autore p : lista){
				out.print("<tr>");
				out.print("<td>" + p.getId() + 	 "</td>");
				out.print("<td>" + p.getNome() + "</td>");
				out.print("<td>" + p.getCognome() + "</td>");
				out.print("<td>" + p.getNazionalita() + "</td>");
 
				out.print("<td>" + 
							"<form method = \"post\" action=\"deleteAutore?idAutore=" + p.getId() + "\">" +
							"<input type=\"submit\">Elimina</input>" +
							"</form> </td>");
				out.print("<td>" + 
						"<form method = \"get\" action=\"modificaAutore\">"+
						"<input type=\"text\" hidden name=\"modificaId\" value=\""+p.getId()+ "\" >" +
						"<input type=\"submit\">Modifica</input>" +
						"</form> </td>");
				out.print("</tr>");
			}
		}else{
			out.print("<br> Non ci sono autori in lista <br>");
		}
 
 
	%>
 
	</table>
 
	<% 
	String msg=(String)request.getAttribute("avvisoMessaggio");
	if(msg!=null){
		out.print("<script>alert(\""+msg+"\");</script>");
	}
	%>
 
</body>
</html>