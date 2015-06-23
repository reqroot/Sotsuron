<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>${page_title}</h1>
<p>${msg}</p>
<form action="/Sotsuron/Kaikei/ShiwakeCho" method="get">
<p>
  <select name="nendo">
<c:forEach var="item" items="${nendo_list}">
    <option value="${item }">${item }</option>
</c:forEach>
  </select>年
  <select name="month">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    <option value="7">7</option>
    <option value="8">8</option>
    <option value="9">9</option>
    <option value="10">10</option>
    <option value="11">11</option>
    <option value="12">12</option>
  </select>月
</p>
  <p><input type="submit" name="btnSearch" value="検索" /></p>
</form>
<hr />
<p><a href="/Sotsuron/Kaikei/ShiwakeCho?page=new_input">新規登録</a></p>
<table border="1">
<tr>
	<th>日</th>
	<th>勘定科目</th>
	<th>科目補助区分</th>
	<th>科目補助</th>
	<th>貸方</th>
	<th>借方</th>
	<th colspan="2">変更/削除</th>
</tr>
<c:forEach var="item" items="${list}">
<tr>
	<td>${item.day}</td>
	<td>${item.kamoku}</td>
	<td>${item.kamokuHojoKBN}</td>
	<td>${item.kamokuHojo}</td>
	<td>${item.kashikata}</td>
	<td>${item.karikata}</td>
	<td><a href="/Sotsuron/Kaikei/ShiwakeCho?page=update_input&nendo=${item.nendo}&month=${item.month}&day=${item.day}&row=${item.row}">変更</a></td>
	<td><a href="/Sotsuron/Kaikei/ShiwakeCho?page=delete&nendo=${item.nendo}&month=${item.month}&day=${item.day}&row=${item.row}">削除</a></td>
</tr>
</c:forEach>
</table>