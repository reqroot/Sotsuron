<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<form id ="search_form" action="/Sotsuron/hanbai/MasterSystem/Member" method="post">
	<input type="hidden" name="state" value="${state }" />
	<p id="form_title">会員検索</p>
	<p id = "input_form">
		<span id ="input_title">ID</span>
		<input type="number" size="10" name="beginID" value="${searchInfo.beginID }" onclick="this.select();">
		～
		<input type="number" size="10" name="endID" value="${searchInfo.endID }" onclick="this.select();"/>
	</p>
	<p id = "input_form">
		<span id ="input_title">登録年月日</span>
		<input type="text" size="10" name="beginDate" value="${searchInfo.beginDateStr }" onclick="this.select();">
		～
		<input type="text" size="10" name="endDate" value="${searchInfo.endDateStr }" onclick="this.select();"/>
	</p>
	<p id = "input_form">
		<span id ="input_title">名前</span>
		<input type="text" size="20" name="name"  value="${searchInfo.name }" onclick="this.select();"/>
	</p>
	<p>
		<input id="submit_button" type="submit" name="searchBtn" value="検索"/>
	</p>
</form>
<hr />
<div id ="msg">${msg} ${state }</div>
<table >
<c:if test="${!(empty list)}">
<tr><th>会員ＩＤ</th><th>氏名</th><th>登録年月日</th></tr>
</c:if>
<c:forEach var="item" items="${list }">

<form action="/Sotsuron/hanbai/MasterSystem/Member" method="post">
	<input type="hidden" name="member_id" value="${item.member_id }" />

	<tr>
		<td>${item.member_id }</td>
		<td>${item.name }</td>
		<td>${item.entry_date}</td>
		<td>
		<c:choose>
			<c:when test="${state == 'select'}">
				<input type="submit" name="detailBtn" value="詳細" />
			</c:when>
			<c:when test="${state == 'edit'}">
				<input type="submit" name="editBtn" value="編集" />
			</c:when>
			<c:when test="${state == 'delete'}">
				<input type="submit" name="deleteBtn" value="削除" />
			</c:when>
		</c:choose>
		</td>
	</tr>
</form>

</c:forEach>

</table>