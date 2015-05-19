<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form method="post" action="./Home">
<p><label for="staff_id">社員ID</label><input type="text" name="staff_id" id="staff_id" size="7" /></p>
<p><label for="password">パスワード</label><input type="password" name="password" id="password" size="10" /></p>
<p><input type="submit" value="送信" /> <input type="reset" value="リセット" /></p>
<p><input type="hidden" name="auth" value="1" />
</form>
