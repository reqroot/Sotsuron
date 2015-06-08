<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.naming.InitialContext, javax.sql.DataSource" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>DB接続テスト</title>
</head>
<body>
<h1>データベース(接続確認)</h1>
<h2>確認結果</h2>
<sql:query var="rs" dataSource="jdbc/MySqlCon">
select enforcement_date, tax_rate from tax
</sql:query>

<c:forEach var="row" items="${rs.rows}">
<p>施工日:${row.enforcement_date}</p>
<p>税率:${row.tax_rate}</p>
</c:forEach>

</body>
</html>