<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>${page_title}</title>
<h1>${page_title}</h1>

<form action="/Sotsuron/Jinji/Staff"  method="post" >
	<p>社員番号：<input type="text" size="7" name="staff_id" value="${staff_id }" required="required" >
	名前：<input type="text" size="20" name="staff_name"  maxlength="20" required="required"/></p>
<p>
部署：
	<select name="department_id">
	<c:forEach var="item" items="${depList }">
	<option value="${item.department_id }" >${item.department_id } : ${item.department_name }</option>
	</c:forEach>
	</select>
役職：
	<select name="position_id">
	<c:forEach var="item" items="${posList }">
	<option value="${item.position_id }">${item.position_id } : ${item.position_name }</option>
	</c:forEach>
	</select>
学歴：
	<select name="education_id">
	<c:forEach var="item" items="${eduList }">
	<option value="${item.education_id }" >${item.education_id } : ${item.education_history }</option>
	</c:forEach>
	</select>
</p>

<p>
生年月日：
	<input type="date" name="birthday" required="required"/>
入社年月日：
	<label>:<input type="date" name="enter_day"  required="required"></label>
基本給：
	<input type="number" name="base_salary" required="required"/>
パスワード：
	<input type="password" name="passwd" size="10" maxlength="20" required="required" />
</p>
	<p><input type="submit" name="add_conf" value="登録" required="required" /></p>
</form>

