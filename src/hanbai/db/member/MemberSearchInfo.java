package hanbai.db.member;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 会員管理画面の検索データを保持するBeans
 * 検索値が逆転していた場合の入れ替えや、Date型を文字列で返す機能を持つ
 * @author 柴田幸雄
 *
 */
public class MemberSearchInfo {
	String beginID;
	String endID;
	Date beginDate;
	Date endDate;
	String name;

	public MemberSearchInfo(){
		beginID = null;
		endID = null;
		beginDate = null;
		endDate = null;
		name = null;
	}

	/**
	 * beginIDを取得します
	 * @return beginID
	 */
	public String getBeginID() {
		return beginID;
	}

	/**
	 * beginIDを設定します
	 * @param beginID 設定するbeginID
	 */
	public void setBeginID(String beginID) {
		this.beginID = beginID;
		replaceID();
	}

	/**
	 * endIDを取得します
	 * @return endID
	 */
	public String getEndID() {
		return endID;
	}

	/**
	 * endIDを設定します
	 * @param endID 設定するendID
	 */
	public void setEndID(String endID) {
		this.endID = endID;
		replaceID();
	}

	/**
	 * beginDateを取得します
	 * @return beginDate
	 */
	public Date getBeginDate() {
		return beginDate;
	}

	public String getBeginDateStr(){
		return new SimpleDateFormat("yyyy/MM/dd").format(beginDate);
	}

	/**
	 * beginDateを設定します
	 * @param beginDate 設定するbeginDate
	 */
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
		replaceDate();
	}

	/**
	 * endDateを取得します
	 * @return endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	public String getEndDateStr(){
		return new SimpleDateFormat("yyyy/MM/dd").format(endDate);
	}

	/**
	 * endDateを設定します
	 * @param endDate 設定するendDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
		replaceDate();
	}

	/**
	 * nameを取得します
	 * @return name
	 */
	public String getName() {
		return name;
	}

	public String getNameSqlParam(){
		if(name == null){
			return "%";
		}else{
			return "%" + name + "%";
		}
	}

	/**
	 * nameを設定します
	 * @param name 設定するname
	 */
	public void setName(String name) {
		this.name = name;
	}

	//IDの検索値が逆転していたら入れ替える
	private void replaceID(){
		if(beginID == null || endID == null) return;

		try{
			//IDを数値に変換
			int begin = Integer.parseInt(beginID);
			int end = Integer.parseInt(endID);
			//開始値のほうが大きければ入れ替える
			if(begin > end){
				String t = beginID;
				beginID = endID;
				endID = t;
			}
		}catch(NumberFormatException e){
			return;
		}
	}

	//日付の検索値が逆転していたら入れ替える
	private void replaceDate(){
		if(beginDate == null || endDate == null) return;

		int diff = beginDate.compareTo(endDate);

		//beginDateのほうが大きければ入れ替える
		if(diff >= 0){
			Date t = beginDate;
			beginDate = endDate;
			endDate = t;
		}
	}
}
