<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--  -->
<form id ="search_form" action="/Sotsuron/hanbai/supplier" method="post">
	<p id = "input_form">
		<span id ="input_title">ID</span>
		<input type="number" size="10" name="beginID"/>
		～
		<input type="number" size="10" name="endID"/>
	</p>
	<p id = "input_form">
		<span id ="input_title">仕入先名</span>
		<input type="text" size="20" name="name"/>
	</p>
	<p id = "input_form">
		<span id ="input_title">買掛金残高</span>
		<input type="number" size="10" name="beginKaikake"/>
		～
		<input type="number" size="10" name="endKaikake"/>
	</p>

	<p>
		<input id="submit_button" type="submit" name="searchBtn" value="検索"/>
	</p>
</form>
<hr />
<div id="list">
<c:forEach var="item" items="${list }">
	<form id="record" action="/sotsuron/Supplier/details" method="post">
		<input type="hidden" name="id" value="${item.supplier_id}" />
		<span id="id">${item.supplier_id} </span>
		<span id="name">${item.name}</span>
		<span id="kaikake">${item.kaikake_zangaku }</span>
		<input id="edit_button" type="submit" name="detailBtn" value= "詳細" />
		<input id="edit_button" type="submit" name="editBtn" value= "編集" />
		<input id="edit_button" type="submit" name="deleteBtn" value= "削除" />
	</form><!-- #form record -->
</c:forEach>
</div><!-- #list -->