<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>${page_title}</title>
<h1>${page_title}</h1>

<form action="/Sotsuron/Jinji/Staff"  method="post" >
	<p>社員番号(例：20xx000 )：<input type="text" size="7" name="staff_id" value="${plist[0].staff_id }" required="required" maxlength="7">
	名前：<input type="text" size="20" name="staff_name"  value = "${plist[0].staff_name }" required="required"/></p>
<p>
部署：
	<select name="department_id">
	<option value = "${department_id}">${plist[0]. department_name}</option>
	<c:forEach var="item" items="${depList }">
	<option value="${item.department_id }" >${item.department_id } : ${item.department_name }</option>
	</c:forEach>
	</select>
役職：
	<select name="position_id">
	<option value="${position_id }">${position_id }${plist[0].position_name }</option>
	<c:forEach var="item" items="${posList }">
	<option value="${item.position_id }">${item.position_id } : ${item.position_name }</option>
	</c:forEach>
	</select>
</p>

<p>
生年月日(例　1999-01-01)：
	<input type="date" name="birthday" value ="${plist[0].birthday }" required="required"/>
入社年月日(例　1999-01-01)：
	<label>:<input type="date" name="enter_day" value="${plist[0].enter_day }"  required="required"></label>
基本給：
	<input type="number" name="base_salary" step="1000" value ="${plist[0].base_salary }" required="required"/>

</p>
	<p><input type="submit" name="update" value="更新"  /></p>
</form>

