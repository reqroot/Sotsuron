<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="item" items="${plist }">
${item.staff_id}
${item.staff_name }
<br />
</c:forEach>
削除しますか？

