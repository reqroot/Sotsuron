<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>${page_title}</h1>

<br />

<table border=1>
<tr>
<th>社員番号</th>
<th>社員名</th>
<th>役職</th>
<th>部署</th>
<th>誕生日</th>
<th>基本給</th>
</tr>

<tr>
<td>${staffInfo.staff_ID }</td>
<td>${staffInfo.staff_Name}</td>
<td>${staffInfo.position_Name}</td>
<td>${staffInfo.department_Name}</td>
<td>${staffInfo.birthDay}</td>
<td>${staffInfo.base_Salary}</td>
</tr>
</table>
