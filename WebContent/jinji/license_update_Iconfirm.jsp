<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>${page_title}</title>
<h1>${page_title}</h1>
<form action="/Sotsuron/Jinji/Staff/License" method="get">
		社員番号:${staff_id }	<br />
		社員名:${staff_name}に資格：${license_name}<br />
		を追加しますか？

		<input type="hidden" name="staff_id" value="${staff_id }" />
		<input type="hidden" name="license_id" value="${license_id }" />
	    <p><input type="submit" name="add" value="確定" /></p>
  </form>