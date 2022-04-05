<%@page import="model.AutoreLibro"%>
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
 <a href="InsertAutoreLibro.jsp">Inserisci relazione</a>
	<table>
	<tr> 
		<th>Autore Id</th>	
		<th>Libro Id</th>
		<th>Cognome</th>
		<th>Titolo</th>	
	</tr>
 
	<%
 		List<AutoreLibro> lista = (List<AutoreLibro>) request.getAttribute("listaAutoriLibri");
		if(lista!=null){
			for(AutoreLibro p : lista){
				out.print("<tr>");
				out.print("<td>" + p.getAlAutoreId() + 	 "</td>");
				out.print("<td>" + p.getAlLibroId() + "</td>");
				out.print("<td>" + p.getaCognome() + "</td>");
				out.print("<td>" + p.getlTitolo() + "</td>");
				out.print("<td>" + 
							"<form method = \"post\" action=\"deleteAutoreLibro?deleteId=" + p.getAlAutoreId()+ "\">" +
							"<input type=\"submit\">Elimina</input>" +
							"</form> </td>");
				
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