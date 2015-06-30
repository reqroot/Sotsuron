<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>${page_title}</h1>
<p>${msg}</p>
<hr />
<form action="./Bank" method="get">
<table border="1">
<tr>
	<th>銀行ID</th>
	<td>${info.bankId}</td>
</tr>
<tr>
	<th>銀行名</th>
	<td><input type="text" name="bank_name" value="${info.bankName}" /></td>
</tr>
</table>
<p><input type="submit" name="newBtn" value="変更" /></p>
<p><input type="hidden" name="page" value="update" /></p>
<p><input type="hidden" name="bank_id" value="${info.bankId}" /></p>
</form>