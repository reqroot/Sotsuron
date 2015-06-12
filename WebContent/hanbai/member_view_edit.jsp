<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id ="msg">${msg}</div>


<form action="/Sotsuron/hanbai/member" method="post">
	<table border="1">
		<tr><th>会員ID</th><td>${item.member_id}</td></tr>
		<tr><th>氏名</th><td><input type="text" value="${item.name}" /></td></tr>
		<tr><th>生年月日</th><td><input type="text" value="${item.birthday}" /></td></tr>
		<tr><th>性別</th><td><input type="text" value="${item.sex}"/></td></tr>
		<tr><th rowspan="3">住所</th><td><input type="text" value="${item.prefecture}"/></td></tr>
		<tr><td><input type="text" value="${item.city}"/></td></tr>
		<tr><td><input type="text" value="${item.address}"/></td></tr>
		<tr><th>電話番号</th><td><input type="text" value="${item.tel}"/></td></tr>
		<tr><th>メールアドレス</th><td><input type="text" value="${item.mail}"/></td></tr>
		<tr><th>登録年月日</th><td>${item.entry_date}</td></tr>
	</table>

	<input type="submit" name="btnOK" value="確認画面へ" />
	<input type="submit" name="btnCansel" value="キャンセル" />

</form>