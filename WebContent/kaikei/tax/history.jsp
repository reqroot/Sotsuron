<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>${page_title}</h1>
<p>${msg}</p>
<hr />
<h2>消費税率履歴</h2>
<table border="1">
<tr>
	<th>施工年月日</th>
	<th>消費税率</th>
</tr>
<c:forEach var="item" items="${list}">
<tr>
	<td>${item.enforcementDate}</td>
	<td>${item.tax}</td>
</tr>
</c:forEach>
</table>