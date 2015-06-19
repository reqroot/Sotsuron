<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>${page_title}</h1>
<p>${msg}</p>
<hr />
<form action="./Customer" method="get">
<table border="1">
<tr>
	<th>取引先名</th>
	<td><input type="text" name="customer_name" /></td>
</tr>
<tr>
	<th>初期売掛金</th>
	<td><input type="text" name="urikake_zangaku" /></td>
</tr>
</table>
<p><input type="submit" name="newBtn" value="登録" /></p>
<p><input type="hidden" name="page" value="new" /></p>
</form>