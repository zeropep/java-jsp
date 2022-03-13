<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="domain.ProductVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Modify Page</title>
</head>
<%
ProductVO pvo = (ProductVO) request.getAttribute("pvo");
%>
<body>
	<h1>Product Modify Page</h1>
	<form action="./update.pd" method="POST">
	<input type="hidden" name="pno" value="<%=pvo.getPno() %>">
		Name: <input type="text" name="pname" placeholder="Item name" value="<%=pvo.getPname() %>"><br>
		Price: <input type="text" name="price" placeholder="Item price" value="<%=pvo.getPrice() %>"><br>
		Made By: <input type="text" name="madeBy" placeholder="Item manufaturer" value="<%=pvo.getMadeBy() %>"><br>
		<button type="submit">Submit</button>		
	</form>
	<h3><a href="./list.pd">Product List</a></h3>
</body>
</html>