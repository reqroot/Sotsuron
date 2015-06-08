<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id ="msg">${msg}</div>

<form id ="search_form" action="/Sotsuron/hanbai/member" method="post">
	<p id="form_title">会員検索</p>
	<p id = "input_form">
		<span id ="input_title">ID</span>
		<input type="number" size="10" name="beginID" value="${beginID }" onclick="this.select();">
		～
		<input type="number" size="10" name="endID" value="${endID }" onclick="this.select();"/>
	</p>
	<p id = "input_form">
		<span id ="input_title">名前</span>
		<input type="text" size="20" name="name"  value="${name }" onclick="this.select();"/>
	</p>
	<p>
		<input id="submit_button" type="submit" name="searchBtn" value="検索"/>
	</p>
</form>
<hr />

<c:forEach var="item" items="${list }">
<form action="/sotsuron/Member/details" method="post">
	<input type="hidden" name="id" value="${item.member_ID }" />
	<div id="record">
		<span>${item.member_ID }</span>
		<span>${item.name }</span>
		<input type="submit" name="btnDetail" value="詳細" />
		<input type="submit" name="btnEdit" value="編集" />
	</div>
</form>
</c:forEach>