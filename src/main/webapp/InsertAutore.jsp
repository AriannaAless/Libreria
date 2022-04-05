<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Inserisci autore <a href="listaAutori"> Indietro </a>
	<form method="post" action="insertAutore">
	
		Nome: <input type="text" name="nome" ><br>
		Cognome:<input type="text" name="cognome" ><br>
		Nazionalita:<input type="text" name="nazionalita" ><br>
		
		<input type="submit" value="Salva">
	</form>
</body>
</html>