package hanbai.validator;

import java.util.Date;

/**
 * Membersテーブルのデータ構造にマッチするようにデータを変換するクラス。
 * @author 柴田
 *
 */
public class MemberValidator extends SotsuronValidator{

	/**
	 * Member.Member_IDにマッチするようにデータを変換する
	 * 桁数が足りなければ左に0を詰める
	 * 桁数が多ければ右の余計な桁を切り捨てる
	 * @param id 変換対象のデータ
	 * @return 変換後のデータ。できなければnull
	 */
	public String convertID(String id){
		try {
			return this.convertInt(id, 0, 9999999, 7);
		} catch (ValidatorException e) {
			setErrMessage("member_id", "IDの値が不正です");
			return null;
		}
	}

	/**
	 * Member.Nameにマッチするようにデータを変換する
	 * @param name 変換対象のデータ
	 * @return 変換後のデータ。できなければnull
	 */
	public String convertName(String name){
		try {
			return substring(name, 20);
		} catch (ValidatorException e) {
			setErrMessage("name", "名前の値が不正です");
			return null;
		}
	}

	/**
	 * Member.Birthday型にマッチするようにデータを変換する
	 * @param date 変換対象のデータ
	 * @return 変換後のデータ。できなければnull
	 */
	public Date convertBirthday(String date){
		 try {
			return this.convertDate(date);
		} catch (ValidatorException e) {
			setErrMessage("birthday", "誕生日の値が不正です");
			return null;
		}
	}

	public String convertBirthdayStr(String date){
		try {
			return this.convertDateStr(date);
		} catch (ValidatorException e) {
			setErrMessage("birthday", "誕生日の値が不正です");
			return null;
		}
	}

	/**
	 * Member.sexにマッチするようにデータを変換する
	 * 0または男であれば、falseに、1または女であればtrueに変換します
	 * @param sex 変換対象のデータ
	 * @return 変換後のデータ。できなければErrMessageにメッセージを追加してfalseを返す
	 */
	public boolean convertSex(String sex) {
		if(sex.equals("女")){
			return true;
		}else if(sex.equals("男")){
			return false;
		}else{
			try{
				return this.convertBoolean(sex);
			}catch(ValidatorException e){
				setErrMessage("sex", "性別の値が不正です");
				return false;
			}
		}
	}

	/**
	 * Member.Prefectureにマッチするようにデータを変換する
	 * @param prefecture 変換対象のデータ
	 * @return 変換後のデータ。できなければnull
	 */
	public String convertPrefecture(String prefecture){
		try {
			return this.substring(prefecture, 4);
		} catch (ValidatorException e) {
			setErrMessage("prefecture", "都道府県の値が不正です");
			return null;
		}
	}

	/**
	 * Member.Cityにマッチするようにデータを変換する
	 * @param city 変換対象のデータ
	 * @return 変換後のデータ。できなければnull
	 */
	public String convertCity(String city) {
		try {
			return this.substring(city, 15);
		} catch (ValidatorException e) {
			setErrMessage("sex", "市町村の値が不正です");
			return null;
		}
	}

	/**
	 * Member.Addressにマッチするようにデータを変換する
	 * @param address 変換対象のデータ
	 * @return 変換後のデータ。できなければnull
	 */
	public String convertAddress(String address) {
		try {
			return this.substring(address, 10);
		} catch (ValidatorException e) {
			setErrMessage("city", "番地の値が不正です");
			return null;
		}
	}

	/**
	 * Member.Telにマッチするようにデータを変換する
	 * @param tel 変換対象のデータ
	 * @return 変換後のデータ。できなければnull
	 */
	public String convertTel(String tel) {
		try {
			return this.convertLong(tel, 0, 99999999999L);
		} catch (ValidatorException e) {
			setErrMessage("tel", "電話番号の値が不正です");
			return null;
		}
	}

	/**
	 * Member.Mailにマッチするようにデータを変換する
	 * @param mail 変換対象のデータ
	 * @return 変換後のデータ。できなければnull
	 */
	public String convertMail(String mail){
		try {
			return this.convertString(mail, 50, ".*@.*");
		} catch (ValidatorException e) {
			setErrMessage("mail", "メールアドレスの値が不正です");
			return null;
		}
	}

	/**
	 * Member.EntryDate型にマッチするようにデータを変換する
	 * @param date 変換対象のデータ
	 * @return 変換後のデータ。できなければnull
	 */
	public Date convertEntryDate(String date){
		 try {
			return this.convertDate(date);
		} catch (ValidatorException e) {
			setErrMessage("birthday", "登録日の値が不正です");
			return null;
		}
	}

	public String convertEntryDateStr(String date){
		try {
			return this.convertDateStr(date);
		} catch (ValidatorException e) {
			setErrMessage("birthday", "登録日の値が不正です");
			return null;
		}
	}

	/**
	 * IDの変換時に発生したエラーメッセージを返します。
	 * ほかのフィールドもこういう感じでエラーメッセージを用意
	 * @return エラーメッセージ。エラーが発生していない場合はnull
	 */
	public String errMessageID(){
		return this.getErrMessage("member_id");
	}
}
