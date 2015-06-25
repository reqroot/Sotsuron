	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	取得済み資格一覧<br />
   	<table border = "1">
   	<tr><th>社員名</th><td>${plist[0].staff_name }</td></tr>
   	<tr><th>資格名</th>
   	<td><c:forEach var="name" items="${sList }">
   	${name.license_name }　
   	</c:forEach></td>
   	</tr>
   	</table>
   	<br />
   	資格の追加・削除
	<form action="/Sotsuron/Jinji/Staff/License"   method="get" >
   	<table border="1">
    <tr><th>社員番号</th><td><input type="text" size="10" name="staff_id" value="${ plist[0].staff_id}" /></td></tr>
    <tr><th><label>資格コード</label></th>
    <td>
	<select name="license_id">
	<c:forEach var="item" items="${lList }">
	<option value="${item.license_id }" >${item.license_id } : ${item.license_name }</option>
	</c:forEach>
	</select>
	</td></tr>
    </table>
    ${msg }
    <input type="hidden" name="staff_name" value="${plist[0].staff_name }" />
    <p><input type="submit" name="add_conf" value="追加" />
   	<input type="submit" name="delete_conf" value="削除" /></p>
 	</form>