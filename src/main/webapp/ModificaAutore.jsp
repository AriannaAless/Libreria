<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Autore</title>
</head>
<body>
Modifica Autore <a href="listaAutori"> Indietro </a>
	<form method="post" action="modificaAutore">
		Id: <input type="number" name="id" hidden value="<%=request.getAttribute("id")%>"><br>
		Nome: <input type="text" name="nome" value="<%=request.getAttribute("nome")%>"><br>
		Cognome:<input type="text" name="cognome" value="<%=request.getAttribute("cognome")%>"><br>
		Nazionalita:<input type="text" name="nazionalita" value="<%=request.getAttribute("nazionalita")%>"><br>
		
		<input type="submit" value="Salva">
	</form>
</body>
</html>