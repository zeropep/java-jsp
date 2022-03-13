<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>

<h2>Employee Modify Page</h2>
	<form action="/emp/update.em" method="POST">
		<div class="mb-3 mt-3">
    		<label for="empno">EMPNO:</label>
    		<input type="text" class="form-control" placeholder="Employee No." name="empno" value="${ evo.empno }" readonly>
    	</div>
    	<div class="mb-3">
    		<label for="ename">ENAME:</label>
			<input type="text" class="form-control" placeholder="Employee Name" name="ename" value="${ evo.ename }">
		</div>
		<div class="mb-3">
			<label for="job">JOB:</label>
			<input type="text" class="form-control" placeholder="Employee Job" name="job" value="${ evo.job }">
		</div>
		<div class="mb-3">
			<label for="mgr">MANAGER:</label>
			<input type="text" class="form-control" placeholder="Employee Manager" name="manager" value="${ evo.mgr }">
		</div>
		<div class="mb-3">
			<label for="hiredate">HIREDATE:</label>
			<input type="text" class="form-control" placeholder="Employee Hiredate" name="hiredate" value="${ evo.hiredate }">
		</div>
		<div class="mb-3">
			<label for="sal">SALARY:</label>
			<input type="text" class="form-control" placeholder="Employee Sal" name="sal" value="${ evo.sal }">
		</div>
		<div class="mb-3">
			<label for="comm">COMMISSION:</label>
			<input type="text" class="form-control" placeholder="Employee Comm" name="comm" value="${ evo.comm }">
		</div>
		<div class="mb-3">
			<label for="deptno">DEPTNO:</label>
			<input type="text" class="form-control" placeholder="Employee deptno" name="deptno" value="${ evo.deptno }">
		</div>
		<button type="submit" class="btn btn-primary">Modify</button>
	</form>
<hr>
<h3><a href="/emp/list.em" type="button" class="btn btn-outline-primary">Employee List</a></h3>
	
<jsp:include page="../footer.jsp"/>