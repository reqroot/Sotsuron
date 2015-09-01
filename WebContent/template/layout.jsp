<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<c:if test="${js != null}">
<meta http-equiv="content-script-type" content="text/javascript" />
</c:if>
<title>${page_title}</title>
<c:if test="${js != null}">
<c:forEach var="item" items="${js}">
<script type="text/javascript" src="${item}"></script>
</c:forEach>
</c:if>
<link href="/Sotsuron/css/common.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<jsp:include page="navigator.jsp" />
	<div id="content">
	<jsp:include page="${content_page}" />
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>