<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id ="msg">${msg}</div>


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