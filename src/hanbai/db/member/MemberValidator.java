package hanbai.db.member;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Membersテーブルのデータ構造にマッチするようにデータを変換するクラス。
 * @author 柴田
 *
 */
public class MemberValidator {

	/**
	 * Member.Member_IDにマッチするようにデータを変換する
	 * 桁数が足りなければ左に0を詰める
	 * 桁数が多ければ右の余計な桁を切り捨てる
	 * @param id 変換対象のデータ
	 * @return 変換後のデータ。できなければnull
	 */
	public String convertID(String id, String defaultID){
		if(id == null || id.length() == 0) return defaultID;
		//数字以外が入っていれば変換できない
		int idInt = 0;
		try{
			idInt = Integer.parseInt(id);
		}catch(NumberFormatException e){
			return defaultID;
		}
		//0以上
		if(0 <= idInt){
			id = String.format("%1$07d", idInt);
		}else{
			return defaultID;
		}
		//9999999より大きい場合
		if(id.length() > 7){
			id = id.substring(0, 7);
		}

		return id;
	}

	/**
	 * Member.nameにマッチするようにデータを変換する
	 * 文字数が多い場合のみ文字を切り捨てる
	 * @param name 変換対象のデータ
	 * @return 変換後のデータ。変換できないときはdefaultNameを返す
	 */
	public String convertName(String name, String defaultName) {
		//nullなら変換不可
		if(name == null || name.length() == 0) return defaultName;
		if(name.length() > 20){
			name = name.substring(0, 20);
		}
		return name;
	}

	public Boolean convertSex(String sex){
		if(sex == null) return null;

		if(sex.equals("0")){

		}
		return null;
	}


	/**
	 * Member.Date型にマッチするようにデータを変換する
	 * @param date 変換対象のデータ
	 * @param defaultDate 変換できない場合のデフォルト値
	 * @return 変換後のデータ。変換できないときはdefaultDateを返す
	 */
	public Date convertDate(String date, Date defaultDate){
		if (date == null || date.equals("")) return defaultDate;

		String[] patterns ={"yyyy/MM/dd", "yyyy/M/d", "yyyy/MM/d","yyyy/M/dd",
							"yyyy-MM-dd", "yyyy-M/d", "yyyy-MM-d","yyyy-M-dd",
							"yyyyMMdd", "yyyyMd", "yyyyMMd","yyyyMdd"};
		SimpleDateFormat[] format = new SimpleDateFormat[patterns.length];
		Date d  = null;

		//いっこずつ検証（効率悪し）
		for(int i = 0; i < format.length; i++){
			format[i] = new SimpleDateFormat(patterns[i]);
		}

		for(SimpleDateFormat s : format){
			try{
				d = s.parse(date);
				break;
			}catch(ParseException e){

			}
		}

		if(d == null){
			return defaultDate;
		}else{
			return d;
		}
	}

}
