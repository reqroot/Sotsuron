<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id ="msg">${msg}</div>


<form action="/Sotsuron/hanbai/MasterSystem/Member" method="post">
	<input type="hidden" name="member_id" value="${item.member_id }"/>
	<input type="hidden" name="entry_date" value="${item.entry_date }" />

	<p id="errMessage">
	<c:forEach var="err" items="${errs }">
		${err }<br />
	</c:forEach>
	</p>
	<table border="1">
		<tr><th>会員ID</th><td>${item.member_id}</td></tr>
		<tr><th>氏名</th><td><input type="text" name="name" value="${item.name}" /></td></tr>
		<tr><th>生年月日</th><td><input type="text" name="birthday" value="${item.birthday}" /></td></tr>
		<tr><th>性別</th>
			<td>
			<select name="sex">
			<option value="1" <c:if test="${item.sexInt == 1}">selected</c:if>>女</option>
			<option value="0" <c:if test="${item.sexInt == 0}">selected</c:if>>男</option>
			</select>
			</td>
		</tr>
		<tr><th rowspan="3">住所</th><td><input type="text" name="prefecture" value="${item.prefecture}"/></td></tr>
		<tr><td><input type="text" name="city" value="${item.city}"/></td></tr>
		<tr><td><input type="text" name="address" value="${item.address}"/></td></tr>
		<tr><th>電話番号</th><td><input type="number" name="tel" value="${item.tel}"/></td></tr>
		<tr><th>メールアドレス</th><td><input type="email" name="mail" value="${item.mail}"/></td></tr>
		<tr><th>登録年月日</th><td>${item.entry_date}</td></tr>
	</table>

	<input type="submit" name="confirmBtn" value="変更確定" />
	<hr />
	<a href="javascript:history.back()">戻る</a>

</form>