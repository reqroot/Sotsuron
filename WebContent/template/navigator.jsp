 <%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="login.LoginInfo" %>

<div id="navigator">
<%--
ここらへんにメニューを記入
 --%>
 <ul>
   <li><a href="/Sotsuron/Kaikei/Jigyosho">事業所情報</a></li>
   <li><a href="/Sotsuron/Kaikei/Bank">取引先銀行</a>
 </ul>

 <p>販売管理</p>
 <ul>
   <li><a href="/Sotsuron/hanbai/supplier">仕入先管理</a></li>
   <li><a href="/Sotsuron/hanbai/genre">ジャンル管理</a></li>
   <li><a href="/Sotsuron/hanbai/member">会員管理</a></li>
 </ul>

  <p>人事管理</p>
 <ul>
   <li><a href="/Sotsuron/Jinji/Staff">社員一覧</a></li>
   <li><a href="">社員検索</a></li>
 </ul>

 <p><a href="/Sotsuron/Logout">ログアウト</a></p>
</div>
