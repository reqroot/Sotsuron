package hanbai.db;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SupplierRegex {
	private String id_regex;
	private Pattern pattern;
	Matcher matcher;

	public SupplierRegex(){

	}

	/**
	 *SupplierIDがDBの型に合っているかを確認する
	 * @param id マッチングするID
	 * @return マッチするならture、そうでないならfalse
	 */
	public boolean matchID(String id){
		if(id == null)return false;
		
		return false;
	}

	/**
	 * 仕入先テーブルの名前列にマッチングしているか確認する
	 * @param name マッチングする名前
	 * @return マッチするならture、そうでないならfalse
	 */
	public boolean matchName(String name){

		return false;
	}

	/**
	 * 仕入先テーブルの買掛残額列にマッチングしているか確認する
	 * @param kaikake マッチングする買掛残額
	 * @return マッチするならture、そうでないならfalse
	 */
	public boolean matchKaikake(int kaikake){
		return false;
	}

	/**
	 * SupplierIDのDBにマッチするようにデータを変換する
	 * 桁数が足りなければ左に0を詰める
	 * 桁数が多ければ右の余計な桁を切り捨てる
	 * @param id 変換対象のデータ
	 * @return 変換後のデータ。できなければnull
	 */
	public String convertID(String id){
		//数字以外が入っていれば変換できない
		try{
			Integer.parseInt(id);
		}catch(NumberFormatException e){
			return null;
		}
		//文字数チェック
		int length = id.length();
		if(length < 4){

		}

		return null;
	}
}
