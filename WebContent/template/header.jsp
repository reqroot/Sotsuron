 <%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
	<h1 id="root_h1">全社統合システム</h1>
	<c:if test="${!empty login_info}">
	<p id="login_info">${login_info.staffId }|<a href="/Sotsuron/Logout">ログアウト</a></p>
	</c:if>
</header>