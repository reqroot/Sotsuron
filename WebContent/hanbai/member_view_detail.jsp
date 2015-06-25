<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id ="msg">${msg}</div>


<form action="/Sotsuron/hanbai/member" method="post">
	<input type="hidden" name="member_id" value="${item.member_id }" />
	<input type="hidden" name="name" value="${item.name }" />
	<input type="hidden" name="birthday" value="${item.birthday }" />
	<input type="hidden" name="sex" value="${item.sex }" />
	<input type="hidden" name="prefecture" value="${item.prefecture }" />
	<input type="hidden" name="city" value="${item.city }" />
	<input type="hidden" name="address" value="${item.address}" />
	<input type="hidden" name="tel" value="${item.tel }" />
	<input type="hidden" name="mail" value="${item.mail }" />
	<input type="hidden" name="entry_date" value="${item.entry_date }" />

	<c:if test="${state != 'delete'}">
	<table border="1">
		<tr><th>会員ID</th><td>${item.member_id}</td></tr>
		<tr><th>氏名</th><td>${item.name}</td></tr>
		<tr><th>生年月日</th><td>${item.birthday}</td></tr>
		<tr><th>性別</th><td>${item.sex}</td></tr>
		<tr><th rowspan="3">住所</th><td>${item.prefecture}</td></tr>
		<tr><td>${item.city}</td></tr>
		<tr><td>${item.address}</td></tr>
		<tr><th>電話番号</th><td>${item.tel}</td></tr>
		<tr><th>メールアドレス</th><td>${item.mail}</td></tr>
		<tr><th>登録年月日</th><td>${item.entry_date }</td></tr>
	</table>
	</c:if>

<c:choose>
	<c:when test="${state == 'detail'}">
		<input type="submit" name="editBtn" value="編集" />
		<input type="submit" name="deleteConfirmBtn" value="削除" />
	</c:when>
	<c:when test="${state == 'confirm'}">
		<input type="submit" name="editBackBtn" value="編集に戻る" />
		<input type="submit" name="commitBtn" value="確定" />
	</c:when>
	<c:when test="${state == 'commit'}">
		<input type="submit" name="backBtn" value="一覧に戻る" />
	</c:when>
	<c:when test="${state == 'deleteConfirm'}">
		<input type="submit" name="backBtn" value="一覧に戻る" />
		<input type="submit" name="deleteBtn" value="削除" />
	</c:when>
	<c:when test="${state == 'delete'}">
		<input type="submit" name="backBtn" value="一覧に戻る" />
	</c:when>
</c:choose>
</form>