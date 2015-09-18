 <%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="login.LoginInfo" %>

<nav>
<%--
ここらへんにメニューを記入
 --%>
 <h2 id="subsystem">一般メニュー</h2>
 <ul>
 <li><a href="/Sotsuron/Jinji/Attendance">出退勤管理</a></li>
 </ul>

 <c:choose>
<c:when test="${login_info.departmentId == '1'}">
   <h2 id="subsystem">人事管理</h2>
 <ul>
   <li><a href="/Sotsuron/Jinji/Staff">社員一覧</a></li>
   <li><a href="/Sotsuron/Jinji/Staff?page=regist">社員登録</a></li>
   <li><a href="/Sotsuron/Jinji/Staff?page=search">社員検索</a></li>
	<li><a href="">給与計算</a></li>
 </ul>
</c:when>
<c:when test="${login_info.departmentId == '2'}">
 <h2 id="subsystem">販売管理</h2>
 <ul>
   <li><a href="/Sotsuron/hanbai/stockSystem">在庫管理</a></li>
   <li><a href="/Sotsuron/hanbai/SearchSystem">商品検索</a></li>
   <li><a href="/Sotsuron/hanbai/salesSystem">売上管理</a></li>
   <li><a href="/Sotsuron/hanbai/MasterSystem">マスタ管理</a></li>
 </ul>
</c:when>
<c:when test="${login_info.departmentId == '3'}">
<h2 id="subsystem">会計管理</h2>
 <ul>
   <li><a href="/Sotsuron/Kaikei/Jigyosho">事業所情報</a></li>
   <li><a href="/Sotsuron/Kaikei/Bank">取引先銀行</a></li>
   <li><a href="/Sotsuron/Kaikei/ShiwakeCho">仕訳帳</a></li>
 </ul>
</c:when>
</c:choose>
 </nav>
