<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>${page_title}</title>
<h1>${page_title}</h1>

<form action="/Sotsuron/Jinji/Staff"  method="get" >
	<p>社員番号(例：20xx000 )：<input type="text" size="7" name="staff_id" value=""  maxlength="7">
	名前：<input type="text" size="20" name="staff_name"  /></p>
<p>
部署：
	<select name="department_id">
	<option value="">なし</option>
	<c:forEach var="item" items="${depList }">
	<option value="" >${item.department_id } : ${item.department_name }</option>
	</c:forEach>
	</select>
役職：
	<select name="position_id">
	<option value="">なし</option>
	<c:forEach var="item" items="${posList }">
	<option value="">${item.position_id } : ${item.position_name }</option>
	</c:forEach>
	</select>
学歴：
	<select name="education_id">
	<option value="">なし</option>
	<c:forEach var="item" items="${eduList }">
	<option value="" >${item.education_id } : ${item.education_history }</option>
	</c:forEach>
	</select>
<input type="submit" name="result" value="検索"  />
</p>

</form>


<br />
<form action="/Sotsuron/Jinji/Staff" method="post">
<table border=1>
<tr>
<th></th>
<th>社員番号</th>
<th>社員名</th>
<th>部署</th>
<th>役職</th>
<th>誕生日</th>
<th>入社年月日</th>
<th>基本給</th>
</tr>
<c:forEach var="item" items="${list }">
<tr>
<td><input type="checkbox" value="${item.staff_id }" name="staffidList" /></td>
<td><a href="/Sotsuron/Jinji/Staff?page=psearch&staff_id=${item.staff_id}" >${item.staff_id}</a></td>
<td>${item.staff_name}</td>
<td>${item.department_name}</td>
<td>${item.position_name }</td>
<td>${item.birthday}</td>
<td>${item.enter_day }</td>
<td>${item.base_salary }</td>

</tr>
</c:forEach>
</table>
<input type="submit" name="delConf" value="削除"/>
</form>

