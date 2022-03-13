<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>

	<h1>Product Modify Page</h1>
	<form action="./update.pd" method="POST">
	<input type="hidden" name="pno" value="${ pvo.pno }">
		Name: <input type="text" name="pname" placeholder="Item name" value="${ pvo.pname }"><br>
		Price: <input type="text" name="price" placeholder="Item price" value="${ pvo.price }"><br>
		Made By: <input type="text" name="madeBy" placeholder="Item manufaturer" value="${ pvo.madeBy }"><br>
		<button type="submit">Submit</button>		
	</form>
	<h3><a href="./list.pd">Product List</a></h3>
	
<jsp:include page="../footer.jsp"/>