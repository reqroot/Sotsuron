package hanbai.db.member;

public class MemberValidator {

	/**
	 * Member.Member_IDにマッチするようにデータを変換する
	 * 桁数が足りなければ左に0を詰める
	 * 桁数が多ければ右の余計な桁を切り捨てる
	 * @param id 変換対象のデータ
	 * @return 変換後のデータ。できなければnull
	 */
	public String convertID(String id){
		if(id == null || id.length() == 0) return null;
		//数字以外が入っていれば変換できない
		int idInt = 0;
		try{
			idInt = Integer.parseInt(id);
		}catch(NumberFormatException e){
			return null;
		}
		//0以上
		if(0 <= idInt){
			id = String.format("%1$07d", idInt);
		}else{
			return null;
		}
		//9999999より大きい場合
		if(id.length() > 7){
			id = id.substring(0, 7);
		}

		return id;
	}

	/**
	 * Supplier.nameにマッチするようにデータを変換する
	 * 文字数が多い場合のみ文字を切り捨てる
	 * @param name 変換対象のデータ
	 * @return 変換後のデータ。できなければnull
	 */
	public String convertName(String name) {
		//nullなら変換不可
		if(name == null || name.length() == 0) return null;
		if(name.length() > 20){
			name = name.substring(0, 20);
		}
		return name;
	}

}
