<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>

<h2>Product Detail
<c:if test="${ses.email eq pvo.writer || ses.grade gt 100 }">
<a href="/prodCtrl/modify?pno=${pvo.pno }" class="btn btn-outline-warning">Mod</a>
<a href="/prodCtrl/remove?pno=${pvo.pno }" class="btn btn-outline-danger">Del</a>
</c:if>
</h2>
  <table class="table table-hover">
      <tr>
        <th>속성</th>
        <th>속성값</th>
      </tr>
      <tr>
        <th>#</th>
        <td>${pvo.pno }</td>
      </tr>
      <tr>
        <th>PName</th>
        <td>${pvo.pname }</td>
      </tr>
      <tr>
        <th>Price</th>
        <td>${pvo.price }</td>
      </tr>
      <tr>
        <th>MadeBy</th>
        <td>${pvo.madeBy }</td>
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
        <td>${pvo.category }</td>
      </tr>
      <tr>
        <th>Description</th>
        <td>${pvo.description }</td>
      </tr>
      <tr>
        <th>Mod At</th>
        <td>${pvo.modAt }</td>
      </tr>
      <tr>
        <th>ReadCount</th>
        <td>${pvo.readCount }</td>
      </tr>
      <tr>
        <th>ImageFile</th>
        <td>${pvo.imageFile }</td>
      </tr>
  </table>
<jsp:include page="../footer.jsp"/>