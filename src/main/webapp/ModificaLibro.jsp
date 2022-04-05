<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Libro</title>
</head>
<body>
Modifica libro <a href="listaLibri"> Indietro </a>
	<form method="post" action="modificaLibro">
		Id: <input type="number" name="id" hidden value="<%=request.getAttribute("id")%>"><br>
		Titolo: <input type="text" name="titolo" value="<%=request.getAttribute("titolo")%>"><br>
		Prezzo:<input type="number" name="prezzo" value="<%=request.getAttribute("prezzo")%>"><br>
		Pagine:<input type="number" name="pagine" value="<%=request.getAttribute("pagine")%>"><br>
		
		<input type="submit" value="Salva">
	</form>
</body>
</html>