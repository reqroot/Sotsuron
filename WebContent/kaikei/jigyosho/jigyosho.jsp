<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>${page_title}</h1>

<hr />
<p><a href="./Jigyosho?page=update_input">事業所情報を更新</a></p>
<table border="1">
  <tr>
    <th>事業所名</th>
    <th>郵便番号</th>
    <th>都道府県</th>
    <th>市町村</th>
    <th>番地</th>
    <th>電話番号</th>
    <th>FAX番号</th>
    <th>資本金</th>
  </tr>
  <tr>
    <td>${jigyosho_info.jigyoshoName }</td>
    <td>${jigyosho_info.postNo}</td>
    <td>${jigyosho_info.prefecture}</td>
    <td>${jigyosho_info.city}</td>
    <td>${jigyosho_info.address}</td>
    <td>${jigyosho_info.tel}</td>
    <td>${jigyosho_info.fax}</td>
    <td>${jigyosho_info.capital}</td>
  </tr>
</table>