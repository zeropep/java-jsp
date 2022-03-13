<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>

	<h2>Employee Detail</h2>
	<ul class="list-group list-group-flush my-3">
		<li class="list-group-item">EMPNO : ${ evo.empno }</li>
		<li class="list-group-item">ENAME : ${ evo.ename }</li>
		<li class="list-group-item">JOB : ${ evo.job }</li>
		<li class="list-group-item">MGR : ${ evo.mgr }</li>
		<li class="list-group-item">HIREDATE : ${ evo.hiredate }</li>
		<li class="list-group-item">SAL : ${ evo.sal }</li>
		<li class="list-group-item">COMM : ${ evo.comm }</li>
		<li class="list-group-item">DEPTNO : ${ evo.deptno }</li>
	</ul>
	<hr>
	<h3><a href="/emp/register.em" type="button" class="btn btn-outline-primary">Employee Register</a></h3>
	<h3><a href="/emp/list.em" type="button" class="btn btn-outline-primary">Employee List</a></h3>
	<h3><a href="/emp/modify.em?empno=${ evo.empno }" type="button" class="btn btn-outline-warning">Employee Modify</a></h3>
	<h3><a href="/emp/remove.em?empno=${ evo.empno }" type="button" class="btn btn-outline-danger">Employee Remove</a></h3>
	
<jsp:include page="../footer.jsp"/>