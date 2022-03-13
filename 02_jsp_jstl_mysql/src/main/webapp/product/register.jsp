<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>

	<h1>Product Register Page Load Success</h1>
	<form action="./insert.pd" method="POST">
		Name: <input type="text" name="pname" placeholder="Item name"><br>
		Price: <input type="text" name="price" placeholder="Item price"><br>
		Made By: <input type="text" name="madeBy" placeholder="Item manufaturer"><br>
		<button type="submit">Submit</button>		
	</form>
	<h3><a href="./list.pd">Product List</a></h3>
	
<jsp:include page="../footer.jsp"/>