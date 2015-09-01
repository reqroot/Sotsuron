 <%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
	<h1>全社統合システム</h1>
	<p>
	<c:if test="${login_info} != null">
	${login_info.staffId }|<a href="/Logout">ログアウト</a>
	</c:if>
</header>