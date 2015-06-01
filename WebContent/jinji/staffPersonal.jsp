<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>${page_title}</title>
<h1>${page_title}</h1>
<h2>${item.staff_id}</h2><br />
${item.staff_name}<br />
${item.department_name}<br />
${item.position_name}<br />
${item.birthday}<br />
${item.enter_day}<br />
${item.base_salary}<br />

<jsp:include page="license.jsp" />

<br />

