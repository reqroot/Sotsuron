<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>${page_title}</title>
<h1>${page_title}</h1>
<div id="clock-02" ></div>
${msg }<br />
<c:if test="${!empty aI.time_in  }">
出勤時間:<fmt:formatDate value="${ aI.time_in}" pattern="kk時mm分" /><br />
</c:if>
<c:if test="${!empty aI.time_out  }">
退勤時間:<fmt:formatDate value="${ aI.time_out}" pattern="kk時mm分" /><br />
</c:if>
<form method="get" action="/Sotsuron/Jinji/Attendance">
<p><input type="submit" name="attend" value="出勤" />
<input type="submit" name="clockout" value="退勤" /></p>
</form>