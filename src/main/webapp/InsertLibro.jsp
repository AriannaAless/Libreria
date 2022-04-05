<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Modifica libro <a href="listaLibri"> Indietro </a>
	<form method="post" action="insertLibro">
	
		Titolo: <input type="text" name="titolo" ><br>
		Prezzo:<input type="number" name="pagine" ><br>
		Pagine:<input type="number" name="prezzo" ><br>
		
		<input type="submit" value="Salva">
	</form>
</body>
</html>