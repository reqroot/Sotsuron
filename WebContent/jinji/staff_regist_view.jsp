<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>${page_title}</title>
<h1>${page_title}</h1>

<form action="/Sotsuron/Jinji/Staff"   method="post" >
	社員番号：<input type="text" size="7" name="staff_id" value="${staff_id }"  >
	名前：<input type="text" size="20" name="staff_name"  maxlength="20" />

	<select name="department_id">
	<c:forEach var="item" items="${depList }">
	<option value="${item.department_id }" >${item.department_id } : ${item.department_name }</option>
	</c:forEach>
	</select>

	<select name="education_id">
	<c:forEach var="item" items="${eduList }">
	<option value="${item.education_id }" >${item.education_id } : ${item.education_history }</option>
	</c:forEach>
	</select>

	<select name="position_id">
	<c:forEach var="item" items="${posList }">
	<option value="${item.position_id }" >${item.position_id } : ${item.position_name }</option>
	</c:forEach>
	</select>
</form>
<input type="button" value ="登録" name="add_conf">