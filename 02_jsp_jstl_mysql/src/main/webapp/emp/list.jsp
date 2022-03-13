<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>
	<h2>Employee List Page</h2>
  	<table class="table">
    	<thead>
    		<tr>
				<th>EMPNO</th>
				<th>ENAME</th>
				<th>JOB</th>
				<th>DEPTNO</th>
    		</tr>
   		</thead>
		<tbody>
		<c:choose>
			<c:when test="${ list.size() > 0 }">
				<c:forEach var="evo" items="#{ list }">
					<tr>
						<td>${ evo.empno }</td>
						<td><a href="/emp/detail.em?empno=${ evo.empno }">${ evo.ename }</a></td>
						<td>${ evo.job }</td>
						<td>${ evo.deptno }</td>
					</tr>
				</c:forEach>
			</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4"><h3>등록된 직원이 없습니다.</h3></td>
					</tr>
				</c:otherwise>
		</c:choose>
		</tbody>
	</table>
	<hr>
	<h3><a href="register.em">Employee Register</a></h3>
	
<jsp:include page="../footer.jsp"/>