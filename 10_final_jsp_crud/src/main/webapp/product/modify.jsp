<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>

<h2>Product Modify</h2>
<form action="/prodCtrl/update" method="POST">
<input type="hidden" name="pno" value="${pvo.pno }">
  <table class="table table-hover">
      <tr>
        <th>속성</th>
        <td>속성값</td>
      </tr>
      <tr>
        <th>#</th>
        <td>${pvo.pno }</td>
      </tr>
      <tr>
        <th>PName</th>
        <td><input type="text" name="pname" value="${pvo.pname }" class="form-control" required></td>
      </tr>
      <tr>
        <th>Price</th>
        <td><input type="text" name="price" value="${pvo.price }" class="form-control" required></td>
      </tr>
      <tr>
        <th>MadeBy</th>
        <td><input type="text" name="madeBy" value="${pvo.madeBy }" class="form-control" required></td>
      </tr>
      <tr>
        <th>Reg At</th>
        <td>${pvo.regAt }</td>
      </tr>
      <tr>
        <th>Writer</th>
        <td>${pvo.writer }</td>
      </tr>
      <tr>
        <th>Category</th>
        <td><input type="text" name="category" value="${pvo.category }" class="form-control" required>${pvo.category }</td>
      </tr>
      <tr>
        <th>Description</th>
        <td><textarea name="desc"  class="form-control" required>${pvo.description }</textarea></td>
      </tr>
      <tr>
        <th>Mod At</th>
        <td>${pvo.modAt }</td>
      </tr>
      <tr>
        <th>ReadCount</th>
        <td>${pvo.readCount - 1 }</td>
      </tr>
      <tr>
        <th>ImageFile</th>
        <td>${pvo.imageFile }</td>
      </tr>
      <tr>
        <td colspan="2" class="text-center">
        <button type="submit" class="btn btn-warning">Update</button></td>
      </tr>
  </table>
</form>

<jsp:include page="../footer.jsp"/>