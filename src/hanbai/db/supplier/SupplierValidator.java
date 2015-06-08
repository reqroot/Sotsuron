package hanbai.db.supplier;



public class SupplierValidator {

	public SupplierValidator(){

	}

	/**
	 * Supplier.SupplierIDにマッチするようにデータを変換する
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
			id = String.format("%1$04d", idInt);
		}else{
			return null;
		}
		//9999より大きい場合
		if(id.length() > 4){
			id = id.substring(0, 4);
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

	/**
	 * Supplier.kaikake_zangakuにマッチするようにデータを変換する
	 * 値が0～9999999999以外だったら丸め込む
	 * @param beginKaikakeStr 変換対象のデータ
	 * @return 変換後のデータ。できなければnull
	 */
	public String convertKaikake(String kaikake) {
		if(kaikake == null || kaikake.length() == 0) return null;
		//数字以外が入っていれば変換できない
		long kaikakeInt = 0;
		try{
			kaikakeInt = Long.parseLong(kaikake);
		}catch(NumberFormatException e){
			return null;
		}

		if(0 <= kaikakeInt){
			kaikake = String.format("%1$010d", kaikakeInt);
		}else{//マイナスだった場合
			return null;
		}
		//9999より大きい場合
		if(kaikake.length() > 10){
			kaikake = kaikake.substring(0, 10);
		}

		return kaikake;
	}
}
