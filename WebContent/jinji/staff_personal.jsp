<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<title>${page_title}</title>
<h1>${page_title}</h1>

社員番号：${plist[0].staff_id }
社員名：${plist[0].staff_name }<br />
部署名：${plist[0]. department_name}<br />
役職：${plist[0].position_name }<br />
誕生日：${plist[0].birthday }<br />
入社年月日：${plist[0].enter_day }<br />
基本給：${plist[0].base_salary }<br />

資格情報：
<%-- 資格情報がないか判断 --%>
<c:if test= "${empty plist[0].license_name }">
	資格情報なし
</c:if>

<%-- リストの長さだけ回す--%>
<c:forEach var="item" items = "${plist}">
${item.license_name }
</c:forEach>

<p><a href="/Sotsuron/Jinji/Staff/License?page=addlicense&staff_id=${plist[0].staff_id}">【資格情報編集】</a>
<a href="/Sotsuron/Jinji/Staff?page=personalEdit&staff_id=${plist[0].staff_id}">【登録情報編集】</a></p>
<br />

