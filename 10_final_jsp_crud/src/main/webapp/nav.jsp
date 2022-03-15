<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="p-5 bg-secondary text-white text-center">
  <h1>My Final JSP EX</h1>
  <p>Resize this responsive page to see the effect!</p> 
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link active" href="/">Home</a>
      </li>
      <c:choose>
      	<c:when test="${ ses.email ne '' && ses.email ne null}">
      	<!-- eq : equal, ne : non-equal -->
      <li class="nav-item">
        <%-- <a class="nav-link" href="${ (ses.grade > 100) ? '/memCtrl/list ' : '/memCtrl/detail?email='ses.email}">${ ses.nickName } (${ ses.email })</a>  --%>     	
      <c:choose>
      	<c:when test="${ ses.grade > 100 }">
        <a class="nav-link" href="/memCtrl/list">${ses.nickName } (${ses.email })</a>      	
      	</c:when>
      	<c:otherwise>
        <a class="nav-link" href="/memCtrl/detail?email=${ses.email }">${ses.nickName } (${ses.email })</a>      	      	
      	</c:otherwise>
      </c:choose>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/memCtrl/logout">Log Out</a>      	
      </li>
      <!-- <li class="nav-item">
        <a class="nav-link" href="prodCtrl/register">Register</a>
      </li> -->
      	</c:when>
      	<c:otherwise>
      <li class="nav-item">
        <a class="nav-link" href="/memCtrl/register">Join</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/member/login.jsp">Log In</a>      	
      </li>
        <!-- 얘도 memCtrl/login으로 할수 있지만 이 방식으로도 가능.
        	원래 이정도에는 그냥 보내는게 맞지만 memCtrl/login으로 컨트롤러를 거치는 것이 스프링의 방식이다. -->
      
      	</c:otherwise>
      </c:choose>
      <li class="nav-item">
        <a class="nav-link" href="/prodCtrl/list">List</a>      	
      </li>
    </ul>
  </div>
</nav>

<div class="container mt-5">