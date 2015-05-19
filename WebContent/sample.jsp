<%--<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> --%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p>表示テスト</p>
<c:if test="${js != null}">
<c:forEach var="item" items="${js}">
<p>${item}</p>
</c:forEach>
</c:if>
