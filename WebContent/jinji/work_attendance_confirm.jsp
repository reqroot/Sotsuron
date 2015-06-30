<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>${page_title}</title>
<h1>${page_title}</h1>

${ aI.date}
<fmt:formatDate value="${ aI.time_in}" pattern="kk時mm分" /><br />
<form method="get" action="/Sotsuron/Jinji/Attendance">
<c:if test="${page_title=='出勤確認画面' }" var="flg"  />
	<c:if test="${flg }" >
	出勤を確定しますか？
	<p><input type="submit" name="add_in" value="確定" />
	</c:if>

	<c:if test="${!flg}" >
	退勤を確定しますか？
	<p><input type="submit" name="add_out" value="確定" />
	</c:if>

<input type="submit" name="cancel" value="戻る" /></p>
</form>