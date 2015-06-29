<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>${page_title}</title>
<h1>${page_title}</h1>


社員番号：${registInfo.staff_id} <br />
社員名：${registInfo.staff_name}<br />
部署：${depList[0].department_name}<br />
役職：${posList[0].position_name}<br />
学歴：${eduList[0].education_history}<br />
<form method="post" action="/Sotsuron/Jinji/Staff">
<input type="submit" value="登録確定" name="add">
</form>