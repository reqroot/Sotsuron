<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>${page_title}</h1>
<p>${msg}</p>
<hr />
<h2>${bank_info.bankName}</h2>
<form action="./Koza" method="get">
<table border="1">
<tr>
	<th>口座番号</th>
	<td><input type="text" name="koza_no" size="40" /></td>
</tr>
<tr>
	<th>口座種別</th>
	<td>
		<select name="koza_shubetsu">
			<c:forEach var="item" items="${ks_list}">
			<option value="${item.kozaShubetsu}">${item.kozaShubetsuName}</option>
			</c:forEach>
		</select>
	</td>
</tr>
<tr>
	<th>初期預金額</th>
	<td><input type="text" name="yokingaku" size="10" /></td>
</tr>
</table>
<p><input type="hidden" name="bank_id" value="${bank_info.bankId }" /></p>
<p><input type="submit" name="newBtn" value="登録" /></p>
<p><input type="hidden" name="page" value="new" /></p>
</form>