<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>${page_title}</h1>
<p>${msg}</p>
<hr />
<h2>${nendo }年度 ${month }月</h2>
<form action="/Sotsuron/Kaikei/ShiwakeCho" method="post">
<table border="1">
<tr>
	<th>日</th>
	<th>勘定科目</th>
	<th>科目補助区分</th>
	<th>科目補助</th>
	<th>貸方</th>
	<th>借方</th>
</tr>
<tr>
	<td>
	<select name="day" size="1">
	<c:forEach var="day" items="${days }">
	<option value="${day }">${day }</option>
	</c:forEach>
	</select>
	</td>
	<td>
	<select name="kamoku" size="1">
	<c:forEach var="kamoku" items="${kamoku_list }">
	${kamoku }
	</c:forEach>
	</select>
	</td>
	<td><input type="text" name="kamoku_hojo_kbn" /></td>
	<td><input type="text" name="kamoku_hojo" /></td>
	<td><input type="text" name="kashikata" /></td>
	<td><input type="text" name="karikata" /></td>
</tr>
</table>
<p><input type="submit" name="shiwake_regist" value="登録">
<input type="hidden" name="nendo" value="${nendo}">
<input type="hidden" name="month" value="${month}"></p>
</form>