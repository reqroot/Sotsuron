<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>${page_title}</title>
<h1>${page_title}</h1>

<div id="clock-02" ></div>
${msg }
<form method="get" action="/Sotsuron/Jinji/Attendance">

<p><input type="submit" name="attend" value="出勤" />
<input type="submit" name="clockout" value="退勤" /></p>

</form>