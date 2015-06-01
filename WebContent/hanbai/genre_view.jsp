<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id ="msg">${msg}</div>
<table border="1">
<tr><th>大分類</th><th>ジャンル</th><th>カテゴリ</th></tr>
<c:forEach var="item" items="${list }">
	<tr>
		<td>${item.grand_name }</td><td>${item.parent_name }</td><td>${item.name }</td>
	</tr>
</c:forEach>
</table><!-- #list -->