<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>${page_title}</h1>
<p>${msg}</p>
<p><a href="/Sotsuron/Kaikei/Tax?page=new_input">消費税率を更新</a></p>
<p><a href="/Sotsuron/Kaikei/Tax?page=history">消費税率の履歴を表示</a></p>
<hr />
<table border="1">
<tr>
	<th>施工年月日</th>
	<td>${info.enforcementDate}</td>
</tr>
<tr>
	<th>消費税率</th>
	<td>${info.tax}</td>
</tr>
</table>