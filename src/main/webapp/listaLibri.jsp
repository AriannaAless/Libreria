<%@page import="model.Libro"%>
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
 <a href="InsertLibro.jsp">Inserisci libro</a>
	<table>
	<tr> 
		<th>ID</th>	
		<th>Titolo</th>
		<th>Prezzo</th>
		<th>Pagine</th>	
	</tr>
 
	<%
 		List<Libro> lista = (List<Libro>) request.getAttribute("listaLibri");
		if(lista!=null){
			for(Libro p : lista){
				out.print("<tr>");
				out.print("<td>" + p.getId() + 	 "</td>");
				out.print("<td>" + p.getTitolo() + "</td>");
				out.print("<td>" + p.getPrezzo() + "</td>");
				out.print("<td>" + p.getPagine() + "</td>");
 
				out.print("<td>" + 
							"<form method = \"post\" action=\"deleteLibro?deleteId=" + p.getId() + "\">" +
							"<input type=\"submit\">Elimina</input>" +
							"</form> </td>");
				out.print("<td>" + 
						"<form method = \"get\" action=\"modificaLibro\">"+
						"<input type=\"text\" hidden name=\"modificaId\" value=\""+p.getId()+ "\" >" +
						"<input type=\"submit\">Modifica</input>" +
						"</form> </td>");
				out.print("</tr>");
			}
		}else{
			out.print("<br> Non ci sono libri in lista <br>");
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