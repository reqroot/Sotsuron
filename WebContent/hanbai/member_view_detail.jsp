<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id ="msg">${msg}</div>


<form action="/Sotsuron/hanbai/MasterSystem/Member" method="post">
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
		<tr><th>郵便番号</th><td>${item.postcode}</td></tr>
		<tr><th rowspan="3">住所</th><td>${item.prefecture}</td></tr>
		<tr><td>${item.city}</td></tr>
		<tr><td>${item.address}</td></tr>
		<tr><th>電話番号</th><td>${item.tel}</td></tr>
		<tr><th>メールアドレス</th><td>${item.mail}</td></tr>
		<tr><th>登録年月日</th><td>${item.entry_date }</td></tr>
		<tr><th>更新年月日</th><td>${item.update_date }</td></tr>
	</table>
	</c:if>

<c:choose>
	<c:when test="${state == 'detail'}"><a href="javascript:history.back()">戻る</a></c:when>

</c:choose>

	<a href="javascript:history.back()">戻る</a>
</form>