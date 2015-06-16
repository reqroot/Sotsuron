<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>${page_title}</h1>
<p>${msg}</p>
<hr />
<form action="./Tax" method="get">
<table border="1">
<tr>
	<th>施工年月日</th>
	<td>
		<input type="text" name="year" size="4" value="${year}" />年
		<input type="text" name="month" size="4" value="${month}" />月
		<input type="text" name="day" size="4" value="${day}" />日
	</td>
</tr>
<tr>
	<th>消費税率</th>
	<td><input type="text" name="tax" size="10" /></td>
</tr>
</table>
<p><input type="submit" name="newBtn" value="登録" /></p>
<p><input type="hidden" name="page" value="new" /></p>
</form>