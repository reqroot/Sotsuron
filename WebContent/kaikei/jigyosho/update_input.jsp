<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>${page_title}</h1>

<hr />

<form action="./Jigyosho" method="get">
<table border="1">
  <tr>
    <th>事業所名</th>
    <td><input type="text" name="jigyosho_name" size="30" value="${jigyosho_info.jigyoshoName }"></td>
  </tr>
  <tr>
    <th>郵便番号</th>
    <td><input type="text" name="post_no" size="8" value="${jigyosho_info.postNo}" /></td>
  </tr>
  <tr>
    <th>都道府県</th>
    <td><input type="text" name="prefecture" size="5" value="${jigyosho_info.prefecture}" /></td>
  </tr>
  <tr>
    <th>市町村</th>
    <td><input type="text" name="city" size="5" value="${jigyosho_info.city}" /></td>
  </tr>
  <tr>
    <th>番地</th>
    <td><input type="text" name="address" size="50" value="${jigyosho_info.address}" /></td>
  </tr>
  <tr>
    <th>電話番号</th>
    <td><input type="text" name="tel" size="20" value="${jigyosho_info.tel}" /></td>
  </tr>
  <tr>
    <th>FAX番号</th>
    <td><input type="text" name="fax" size="20" value="${jigyosho_info.fax}" /></td>
  </tr>
  <tr>
    <th>資本金</th>
    <td><input type="text" name="capital" size="20" value="${jigyosho_info.capital}" /></td>
  </tr>
</table>
<p><input type="submit" name="btnUpdReg" value="送信" /></p>
<p><input type="hidden" name="page" value="update" /></p>
</form>