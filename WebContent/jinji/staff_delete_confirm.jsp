<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="/Sotsuron/Jinji/Staff" method="post">
<c:forEach var="item" items="${plist }">
${item.staff_id}
${item.staff_name }
<input type="hidden" name="staffidList" value="${item.staff_id}"/>
<br />
</c:forEach>
削除しますか？
<input type="submit" name="delete" value="確定" />
</form>

