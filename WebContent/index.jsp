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
<title>${page_title}</title>
<c:if test="${js != null}">
<c:forEach var="item" items="${js}">
<script type="text/javascript" src="${item}"></script>
</c:forEach>
</c:if>
</head>
<body>
	<jsp:include page="./template/header.jsp"/>
	<div id="content">

<c:if test="${err_msg != null}">
  <p class="err">${err_msg}</p>
  <hr />
</c:if>
<form method="post" action="Login">
<p><label for="staff_id">社員ID</label><input type="text" name="staff_id" id="staff_id" size="7" /></p>
<p><label for="password">パスワード</label><input type="password" name="passwd" id="passwd" size="10" /></p>
<p><input type="submit" value="送信" /> <input type="reset" value="リセット" /></p>
<p><input type="hidden" name="auth" value="1" /></p>
</form>
	</div>
	<jsp:include page="./template/footer.jsp"/>
</body>
</html>