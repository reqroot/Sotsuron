<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>${page_title}</title>
<h1>${page_title}</h1>
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

