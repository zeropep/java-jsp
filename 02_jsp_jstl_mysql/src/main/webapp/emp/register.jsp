<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>

<h2>Employee Register Page</h2>
  <form action="/emp/insert.em" method="POST">
    <div class="mb-3 mt-3">
      <label for="empno">EMPNO:</label>
      <input type="text" class="form-control" placeholder="Employee No." name="empno">
    </div>
    <div class="mb-3">
      <label for="ename">ENAME:</label>
      <input type="text" class="form-control" placeholder="Employee Name" name="ename">
    </div>
    <div class="mb-3">
      <label for="job">JOB:</label>
      <input type="text" class="form-control" placeholder="Employee Job" name="job">
    </div>
    <div class="mb-3">
      <label for="hiredate">HIREDATE:</label>
      <input type="text" class="form-control" placeholder="Employee Hiredate" name="hiredate">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
  <hr>
<h3><a href="/emp/list.em">Employee List</a></h3>
	
<jsp:include page="../footer.jsp"/>