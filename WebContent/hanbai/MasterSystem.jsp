<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>マスタ管理</h3>
<div id ="msg">${msg}</div>



	<ul>
		<li>
			<form action="/Sotsuron/hanbai/MasterSystem/Member" method="post">
				会員マスタ
				<input type="submit" name="search" value="検索" />
				<input type="submit" name="add" value="登録" />
				<input type="submit" name="edit" value="編集" />
				<input type="submit" name="delete" value="削除" />
			</form>
		</li>
		<li>
			<form action="/Sotsuron/hanbai/MasterSystem/Supplier" method="post">
				仕入先マスタ
				<input type="submit" name="supplier_search" value="検索" />
				<input type="submit" name="supplier_add" value="登録" />
				<input type="submit" name="supplier_edit" value="編集" />
				<input type="submit" name="supplier_delete" value="削除" />
			</form>
		</li>
		<li>
			<form action="/Sotsuron/hanbai/MasterSystem/Publisher" method="post">
				出版社マスタ
				<input type="submit" name="publisher_search" value="検索" />
				<input type="submit" name="publisher_add" value="登録" />
				<input type="submit" name="publisher_edit" value="編集" />
				<input type="submit" name="publisher_delete" value="削除" />
			</form>
		</li>
		<li>
			<form action="/Sotsuron/hanbai/MasterSystem/Genre" method="post">
				ジャンルマスタ
				<input type="submit" name="genre_search" value="検索" />
				<input type="submit" name="genre_add" value="登録" />
				<input type="submit" name="genre_edit" value="編集" />
				<input type="submit" name="genre_delete" value="削除" />
			</form>
		</li>
		<li>
			<form action="/Sotsuron/hanbai/MasterSystem/SaleTerm" method="post">
				販売条件マスタ
				<input type="submit" name="saleTerm_search" value="検索" />
				<input type="submit" name="saleTerm_add" value="登録" />
				<input type="submit" name="saleTerm_edit" value="編集" />
				<input type="submit" name="saleTerm_delete" value="削除" />
			</form>
		</li>
		<li>
			<form action="/Sotsuron/hanbai/MasterSystem/Item" method="post">
				商品マスタ
				<input type="submit" name="item_search" value="検索" />
				<input type="submit" name="item_add" value="登録" />
				<input type="submit" name="item_edit" value="編集" />
				<input type="submit" name="item_delete" value="削除" />
			</form>
		</li>
		<li>
			<form action="/Sotsuron/hanbai/MasterSystem/Group" method="post">
				商品分類マスタ
				<input type="submit" name="group_search" value="検索" />
				<input type="submit" name="group_add" value="登録" />
				<input type="submit" name="group_edit" value="編集" />
				<input type="submit" name="group_delete" value="削除" />
			</form>
		</li>
	</ul>

<!-- action MasterSystem post -->