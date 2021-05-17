<%@page import="org.mql.store.models.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Liste des Produits :</h1>
	<%
		List<Product> products = (List<Product>)request.getAttribute("model");
	%>
	<table border="1" style="border-collapse: collapse;width: 100%;">
		<tr><th>Id</th><th>Nom</th><th>Année</th></tr>
		<%
			for(Product product : products) {
		%>
		<tr>
			<td><%= product.getId_ref() %></td>
			<td><%= product.getName() %></td>
			<td><%= product.getImage() %></td>
			<td><%= product.getPrice() %></td>
		</tr>
		<%
			}
		%>
		
	</table>
</body>
</html>