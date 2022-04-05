<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Inserisci Autore libro <a href="listaAutoriLibri"> Indietro </a>
	<form method="post" action="insertAutoreLibro">
	
		Autore_id: <input type="number" name="a_id" ><br>
		Libro_id:<input type="number" name="l_id" ><br>
		
		
		<input type="submit" value="Salva">
	</form>
</body>
</html>