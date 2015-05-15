<%--<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> --%>
<%@ page pageEncoding="UTF-8" %>
  <jsp:include page="./template/layout.jsp">
<jsp:param name="title" value="ログインページ"/>
<jsp:param name="content">
<jsp:attribute name="value">

<form>
<p><label for="staff_id">社員ID</label><input type="text" name="staff_id" id="staff_id" size="7" /></p>
<p><label for="password">パスワード</label><input type="password" name="password" id="password" size="10" /></p>
<p><input type="submit" value="送信" /> <input type="reset" value="リセット" /></p>
</form>

</jsp:attribute>
</jsp:param>
</jsp:include>