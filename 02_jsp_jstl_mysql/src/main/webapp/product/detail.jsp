<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>

	<h1>Product Detail Page</h1>
	<ul>
		<li>PNO : ${ pvo.pno }</li>
		<li>PNAME : ${ pvo.pname }</li>
		<li>PRICE : ${ pvo.price }</li>
		<li>REGDATE : ${ pvo.regDate }</li>
		<li>MADE BY : ${ pvo.madeBy }</li>
	</ul>
	<h3><a href="./register.pd">Product Register</a></h3>
	<h3><a href="./list.pd">Product List</a></h3>
	<h3><a href="./modify.pd?pno=${ pvo.pno }">Product Modify</a></h3>
	<h3><a href="./remove.pd?pno=${ pvo.pno }">Product Remove</a></h3>
	
<jsp:include page="../footer.jsp"/>