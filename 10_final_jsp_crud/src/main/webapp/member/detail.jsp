<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>

<form action="/memCtrl/modify" method="POST" id="modForm">
<input type="hidden" name="email" value="${mvo.email }">
  <ul class="list-group list-group-flush">
    <li class="list-group-item">Email : ${mvo.email }</li>
    <li class="list-group-item">
    	Password : <input type="text" value="${mvo.pwd }" name="pwd"></li>
    <li class="list-group-item">
    	Nickname : <input type="text" value="${mvo.nickName }" name="nickName"></li>
    <li class="list-group-item">Reg At : ${mvo.regAt }</li>
    <li class="list-group-item">Last Login : ${mvo.lastLogin }</li>
    <li class="list-group-item">Grade : ${mvo.grade > 50 ? 'VIP' : mvo.grade > 30 ? 'Great' : 'Basic' }</li>
  </ul>
<button type="submit" class="btn btn-outline-warning">Modify Profile</button>
<button type="submit" class="btn btn-outline-danger" id="resignBtn">Remove Profile</button>
</form>
<script src="/resources/js/member.detail.js"></script>
<jsp:include page="../footer.jsp"/>