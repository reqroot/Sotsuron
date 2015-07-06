<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>${page_title}</title>
<h1>${page_title}</h1>


社員番号：${registInfo.staff_id} <br />
社員名：${registInfo.staff_name}<br />
部署：${depList[0].department_name}<br />
役職：${posList[0].position_name}<br />
学歴：${eduList[0].education_history}<br />
誕生日：${registInfo.birthday }<br/>
入社年月日：${registInfo.enter_day }<br/>
基本給：${registInfo.base_salary}<br/>


上記の内容で登録しますか？
<form method="post" action="/Sotsuron/Jinji/Staff">
<input type="hidden" name="staff_id" value="${registInfo.staff_id}" />
<input type="hidden" name="staff_name" value="${registInfo.staff_name}" />
<input type="hidden" name="department_id" value="${registInfo.department_id}" />
<input type="hidden" name="position_id" value="${registInfo.position_id}" />
<input type="hidden" name="education_id" value="${registInfo.education_id}" />
<input type="hidden" name="birthday" value="${registInfo.birthday}" />
<input type="hidden" name="enter_day" value="${registInfo.enter_day }" />
<input type="hidden" name="base_salary" value="${registInfo.base_salary}" />
<input type="hidden" name="password" value="${registInfo.passwd}" />
<input type="submit" value="登録確定" name="add">
</form>