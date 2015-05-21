<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>${page_title}</h1>

<br />

<table border=1>
<tr>
<th>社員番号</th>
<th>社員名</th>
<th>部署</th>
<th>誕生日</th>
<th>基本給</th>
</tr>

<tr>
<td>${staffInfo.staffID }</td>
<td>${staffInfo.staffName}</td>
<td>${staffInfo.departmentName}</td>
<td>${staffInfo.birthDay}</td>
<td>${staffInfo.baseSalary}</td>
</tr>
</table>