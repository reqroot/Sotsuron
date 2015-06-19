package hanbai.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SotsuronValidator {

	private HashMap<String, String> errMessage;

	public SotsuronValidator(){
		errMessage = new HashMap<String, String>();
	}

	/**
	 * 文字列がboolean型に変換できるか検証し、booleanの値を返す
	 * 変換できる文字列は"1""0"です
	 * @param value 変換対象のデータ
	 * @return true or false
	 * @throws ValidatorException 変換できなかった場合に発生する
	 */
	protected boolean convertBoolean(String bool) throws ValidatorException{
		if(bool.equals("0")){
			return false;
		}else if (bool.equals("1")){
			return true;
		}else{
			throw new ValidatorException();
		}
	}



	/**
	 * 文字列がboolean型に変換できるか検証し、booleanの値に対応する文字列を返す
	 * @param value 変換対象のデータ
	 * @param trueValue trueに変換できた場合に返す値
	 * @param falseValue falseに変換できた場合に返す値
	 * @return booleanの値に対応する文字列
	 * @throws ValidatorException 変換できなかった場合に発生する
	 */
	protected String convertBoolean(String value, String trueValue, String falseValue) throws ValidatorException{
		if(value == null) new ValidatorException();

		try{
			return convertBoolean(value) ? trueValue : falseValue;
		}catch(IllegalArgumentException e){
			throw new ValidatorException();
		}
	}

	/**
	 * 文字列がint型に変換できるかを検証し、指定された範囲内の指定された桁数の数値の文字列に変換する
	 * begin > endである場合は、先にbeginとendの値を入れ替えたうえで検証を行います
	 * @param value 変換対象の文字列
	 * @param begin 数値の範囲の開始値
	 * @param end 数値の範囲の終了値
	 * @return 変換後のデータ
	 * @throws ValidatorException 変換できなかった場合に発生します。
	 */
	protected String convertInt(String value, int begin, int end) throws ValidatorException{
		if(value == null || value.equals("")) throw new ValidatorException();

		//begin>endなら逆転
		if(begin > end){
			int i = end;
			end = begin;
			begin = i;
		}
		//検証
		try{
			int dataInt = Integer.parseInt(value);

			if(begin <= dataInt && dataInt <= end){
				return value;
			}else{
				throw new ValidatorException();
			}
		}catch(NumberFormatException e){
			throw new ValidatorException();
		}
	}

	/**
	 * 文字列がint型に変換できるかを検証し、指定された範囲内の指定された桁数の数値の文字列に変換する
	 * valueがketaより長い場合は、右側を切り捨てたうえで数値型の検証を行い、範囲内であれば0で字詰めした上でString型の数値を返します。
	 * begin > endである場合は、先にbeginとendの値を入れ替えたうえで検証を行います
	 * @param value 変換対象の文字列
	 * @param begin 数値の範囲の開始値
	 * @param end 数値の範囲の終了値
	 * @param keta 数値の桁数
	 * @return 変換後のデータ
	 * @throws ValidatorException 変換できなかった場合に発生します。
	 */
	protected String convertInt(String value, int begin, int end, int keta) throws ValidatorException{
		//桁数以上の文字を削除
		if(value.length() > keta){
			value =value.substring(0, keta);
		}

		String result = convertInt(value, begin, end);

		//フォーマットの作成
		StringBuilder sb = new StringBuilder();
		sb.append("%1$0");
		sb.append(keta);
		sb.append("d");

		//0で字詰めフォーマット
		return String.format(sb.toString(), Integer.parseInt(result));
	}

	/**
	 * 文字列がint型に変換できるかを検証し、指定された範囲内の指定された桁数の数値の文字列に変換する
	 * begin > endである場合は、先にbeginとendの値を入れ替えたうえで検証を行います
	 * @param value 変換対象の文字列
	 * @param begin 数値の範囲の開始値
	 * @param end 数値の範囲の終了値
	 * @return 変換後のデータ
	 * @throws ValidatorException 変換できなかった場合に発生します。
	 */
	protected String convertLong(String value, long begin, long end) throws ValidatorException{
		if(value == null || value.equals("")) throw new ValidatorException();

		//begin>endなら逆転
		if(begin > end){
			long i = end;
			end = begin;
			begin = i;
		}
		//検証
		try{
			long dataLong = Long.parseLong(value);

			if(begin <= dataLong && dataLong <= end){
				return value;
			}else{
				throw new ValidatorException();
			}
		}catch(NumberFormatException e){
			throw new ValidatorException();
		}
	}

	/**
	 * 文字列がint型に変換できるかを検証し、指定された範囲内の指定された桁数の数値の文字列に変換する
	 * valueがketaより長い場合は、右側を切り捨てたうえで数値型の検証を行い、範囲内であれば0で字詰めした上でString型の数値を返します。
	 * begin > endである場合は、先にbeginとendの値を入れ替えたうえで検証を行います
	 * @param value 変換対象の文字列
	 * @param begin 数値の範囲の開始値
	 * @param end 数値の範囲の終了値
	 * @param keta 数値の桁数
	 * @return 変換後のデータ
	 * @throws ValidatorException 変換できなかった場合に発生します。
	 */
	protected String convertLong(String value, Long begin, Long end, int keta) throws ValidatorException{
		//桁数以上の文字を削除
		if(value.length() > keta){
			value =value.substring(0, keta);
		}

		String result = convertLong(value, begin, end);

		//フォーマットの作成
		StringBuilder sb = new StringBuilder();
		sb.append("%1$0");
		sb.append(keta);
		sb.append("d");

		//0で字詰めフォーマット
		return String.format(sb.toString(), Integer.parseInt(result));
	}
	/**
	 * Member.Date型にマッチするようにデータを変換する
	 * @param date 変換対象のデータ
	 * @return 変換後のデータ。
	 * @throws ValidatorException 変換できなかった場合に発生する
	 */
	protected Date convertDate(String date) throws ValidatorException{
		if (date == null || date.equals("")) new ValidatorException("");

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
			throw new ValidatorException();
		}else{
			return d;
		}
	}

	/**
	 * Member.Date型にマッチするようにデータを変換し、特定のフォーマットのString型で返す
	 * このメソッドは内部でconvertDate(String date, Date defaultDate)を呼び出しています。
	 * 返される日付のフォーマットは yyyy/MM/dd です。
	 * @param date 変換対象のデータ
	 * @return 変換後のデータ
	 * @throws ValidatorException 変換できなかった場合には例外Exceptinを発生させる
	 */
	protected String convertDateStr(String date) throws ValidatorException{
		return new SimpleDateFormat("yyyy/MM/dd").format(convertDate(date));
	}


	/**
	 * 指定された文字数に切り捨てたうえで、正規表現にマッチするか検証します。
	 * @param value 対象のデータ
	 * @param maxLength 最大文字数
	 * @param regex 正規表現
	 * @return 変換後のデータ
	 * @throws ValidatorException 変換できなかった場合に発生します。
	 */
	protected String convertString(String value, int maxLength, String regex) throws ValidatorException{
		//substring
		value = substring(value, maxLength);

		//正規表現に当てはめる
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(value);

		//値を戻す
		if(m.find()){
			return value;
		}else{
			throw new ValidatorException();
		}
	}

	/**
	 * 指定された文字数に収まるように文字をカットして返す。
	 * 文字列が指定された文字数以下の場合はそのまま返す
	 * dataにnullが指定されたとき及びmaxLengthが0以下の場合は例外を返す
	 * @param data 変換対象の文字列
	 * @param maxLength 最大文字数。
	 * @return カット後の文字列
	 * @throws Exception 変換できなかった場合には例外Exceptinを発生させる
	 */
	protected String substring(String data, int maxLength) throws ValidatorException{
		if(data == null || data.equals("") || maxLength <= 0) throw new ValidatorException();;

		if(data.length() > maxLength){
			return data.substring(0, maxLength);
		}else{
			return data;
		}
	}

	/**
	 * 文字列が範囲内の数値であるかどうか調べる
	 * @param value 対象のデータ
	 * @param begin 範囲の開始値
	 * @param end 範囲の狩猟地
	 * @return 変換できるならtrue、できないならfalse
	 */
	protected boolean validateInt(String value, int begin, int end) throws ValidatorException{
		if(value == null || value.equals("")) throw new ValidatorException();
		try{
			int dataInt = Integer.parseInt(value);

			if(begin <= dataInt && dataInt <= end){
				return true;
			}else{
				return false;
			}
		}catch(NumberFormatException e){
			return false;
		}
	}

	/**
	 * 文字列が範囲内の数値であるかどうか調べる
	 * @param value 対象のデータ
	 * @param begin 範囲の開始値
	 * @param end 範囲の狩猟地
	 * @return 変換できるならtrue、できないならfalse
	 */
	protected boolean validateLong(String value, long begin, long end) throws ValidatorException{
		if(value == null || value.equals("")) throw new ValidatorException();
		try{
			long dataLong = Long.parseLong(value);

			if(begin <= dataLong && dataLong <= end){
				return true;
			}else{
				return false;
			}
		}catch(NumberFormatException e){
			return false;
		}
	}

	/**
	 * エラーメッセージを取得します
	 * @param fieldName 取得するフィールド名
	 * @return エラーメッセージ。ない場合はnull
	 */
	public String getErrMessage(String fieldName){
		return errMessage.get(fieldName);
	}

	/**
	 * エラーメッセージを設定します
	 * @param key 設定するフィールド名
	 * @param message メッセージ
	 */
	protected void setErrMessage(String key, String message){
		errMessage.put(key, message);
	}

	/**
	 * 保持されているエラー数を返す
	 * @return エラー数
	 */
	public int getErrs(){
		return errMessage.size();
	}
}
