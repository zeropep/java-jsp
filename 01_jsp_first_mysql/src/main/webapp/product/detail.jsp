<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="domain.ProductVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Detail Page</title>
</head>
<%
ProductVO pvo = (ProductVO) request.getAttribute("pvo");
%>
<body>
	<h1>Product Detail Page</h1>
	<ul>
		<li>PNO : <%=pvo.getPno() %></li>
		<li>PNAME : <%=pvo.getPname() %></li>
		<li>PRICE : <%=pvo.getPrice() %></li>
		<li>REGDATE : <%=pvo.getRegDate() %></li>
		<li>MADE BY : <%=pvo.getMadeBy() %></li>
	</ul>
	<h3><a href="./register.pd">Product Register</a></h3>
	<h3><a href="./list.pd">Product List</a></h3>
	<h3><a href="./modify.pd?pno=<%=pvo.getPno() %>">Product Modify</a></h3>
	<h3><a href="./remove.pd?pno=<%=pvo.getPno() %>">Product Remove</a></h3>
</body>
</html>