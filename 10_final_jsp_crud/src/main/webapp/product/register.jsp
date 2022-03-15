<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>

<form action="/prodCtrl/insert" method="POST">
  <div class="mb-3 mt-3">
    <label for="pname" class="form-label">Product Name:</label>
    <input type="text" class="form-control" id="pname" placeholder="Enter pname" name="pname">
  </div>
  <div class="mb-3">
    <label for="price" class="form-label">Price:</label>
    <input type="text" class="form-control" id="price" placeholder="Enter price" name="price">
  </div>
  <div class="mb-3">
    <label for="madeBy" class="form-label">Manufacturer:</label>
    <input type="text" class="form-control" id="madeBy" placeholder="Enter Manufacturer" name="madeBy">
  </div>
  <div class="mb-3">
    <label for="writer" class="form-label">Writer:</label>
    <input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer">
  </div>
  <div class="mb-3">
    <label for="category" class="form-label">Category:</label>
    <input type="text" class="form-control" id="category" placeholder="Enter category" name="category">
  </div>
  <div class="mb-3">
    <label for="desc" class="form-label">Description:</label>
    <textarea class="form-control" id="desc" placeholder="Enter description" name="desc"></textarea>
  </div>
  <button type="submit" class="btn btn-secondary">Submit</button>
</form>

<jsp:include page="../footer.jsp"/>