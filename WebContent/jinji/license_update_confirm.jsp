<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>${page_title}</title>
<h1>${page_title}</h1>
<form action="/Sotsuron/Jinji/Staff/License" method="get">
	<c:if test="${page_title=='人事システム - 資格追加確認ページ' }" var="flg"  />
	<c:if test="${flg }" >
		社員番号:${staff_id }	<br />
		社員名:${staff_name}に資格：${license_name}<br />
		を追加しますか？
	<p><input type="submit" name="add" value="確定" />
	</c:if>

	<c:if test="${!flg}" >
		社員番号:${staff_id }	<br />
		社員名:${staff_name}に資格：${license_name}<br />
		を削除しますか？
	<p><input type="submit" name="delete" value="確定" />
	</c:if>
	<input type="submit" name="cancel" value="戻る"  onClick="history.go(-1)" /></p>
	<input type="hidden" name="staff_id" value="${staff_id }" />
	<input type="hidden" name="license_id" value="${license_id }" />
	</form>

