<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>${page_title}</h1>
<p>${msg}</p>
<p><a href="/Sotsuron/Kaikei/Bank?page=new_input">取引銀行を新規登録する</a></p>
<hr />
<table border="1">
<tr>
	<th>銀行ID</th>
	<th>銀行名</th>
	<th>登録口座</th>
	<th colspan="2">変更/削除</th>
</tr>
<c:forEach var="item" items="${list}">
<tr>
	<td>${item.bankId}</td>
	<td>${item.bankName}</td>
	<td><a href="/Sotsuron/Kaikei/Koza?page=koza&bank_id=${item.bankId}">登録口座を確認する</a></td>
	<td><a href="/Sotsuron/Kaikei/Bank?page=update_input&bank_id=${item.bankId}">変更</a></td>
	<td><a href="/Sotsuron/Kaikei/Bank?page=delete&bank_id=${item.bankId}">削除</a></td>
</tr>
</c:forEach>
</table>