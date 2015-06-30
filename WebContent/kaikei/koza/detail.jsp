<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>${page_title}</h1>
<p>${msg}</p>
<hr />
<h2>${bank_info.bankName} - ${info.kozaShubetsu}:${info.kozaNo }</h2>
<p>口座残高：${info.kozaZangaku}</p>