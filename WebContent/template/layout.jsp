<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<c:if test="${js != null}">
<meta http-equiv="content-script-type" content="text/javascript" />
</c:if>
<title>${param.title}</title>
<c:if test="${js != null}">
<c:forEach var="item" items="${js}">
<script type="text/javascript" src="${item}"></script>
</c:forEach>
</c:if>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<jsp:include page="navigator.jsp" />
	<div id="content">
	${param.content}
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>