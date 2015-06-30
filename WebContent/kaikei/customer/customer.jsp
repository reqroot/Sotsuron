<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>${page_title}</h1>
<p>${msg}</p>
<hr />
<p><a href="/Sotsuron/Kaikei/Customer?page=new_input">取引先を新規登録する</a></p>
<table border="1">
<tr>
	<th>取引先ID</th>
	<th>取引先名</th>
	<th>売掛金残額</th>
</tr>
<c:forEach var="item" items="${list}">
<tr>
	<td>${item.customerId}</td>
	<td>${item.customerName}</td>
	<td>${item.urikakeZangaku }</td>
</tr>
</c:forEach>
</table>