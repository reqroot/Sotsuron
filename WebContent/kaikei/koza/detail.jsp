<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>${page_title}</h1>
<p>${msg}</p>
<hr />
<h2>${bank_info.bankName} - 口座詳細</h2>
<table border="1">
<tr>
	<th>口座番号</th>
	<th>口座種別</th>
	<th></th>
</tr>
<c:forEach var="item" items="${list}">
<tr>
	<td><a href="/Sotsuron/Kaikei/Koza?page=detail&bank_id=${item.bankId}&koza_no=${item.kozaNo}">${item.kozaNo}</a></td>
	<td>${item.kozaShubetsu}</td>
	<td><a href="/Sotsuron/Kaikei/Koza?page=delete&bank_id=${item.bankId}">削除</a></td>
</tr>
</c:forEach>
</table>