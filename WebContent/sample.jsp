<%--<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> --%>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.List, java.util.ArrayList"  %>
<%-- javascriptの追加ここから --%>
 <%
 	List<String> list = new ArrayList<String>();
 	list.add("../js/jquery-1.11.3.js");
 	request.setAttribute("js", list);
 %>
<%-- javascriptの追加ここまで --%>
<jsp:include page="./template/layout.jsp">
<jsp:param name="title" value="ログインページ"/>
<%-- javascriptを追加する場合、追加処理のほかに以下を追加する --%>
<jsp:param name="js" value="${js}"/>
<jsp:param name="content">
<jsp:attribute name="value">
<%-- コンテンツの編集ここから --%>

<p>表示テスト</p>

<%-- コンテンツの編集ここまで --%>
</jsp:attribute>
</jsp:param>
</jsp:include>