package hanbai.db.genre;

public class GenreInfo {
	private String genre_id;
	private String name;
	private String parent_genre_id;
	private String parent_name;
	private String grand_name;

	public GenreInfo(){}

	public GenreInfo(String genre_id, String name, String parent_genre_id) {
		super();
		this.genre_id = genre_id;
		this.name = name;
		this.parent_genre_id = parent_genre_id;
	}

	/**
	 * ジャンルIDを取得します
	 * @return genre_id
	 */
	public String getGenre_id() {
		return genre_id;
	}
	/**
	 * ジャンルIDを設定します
	 * @param genre_id 設定するジャンルID
	 */
	public void setGenre_id(String genre_id) {
		this.genre_id = genre_id;
	}
	/**
	 * ジャンル名を取得します
	 * @return ジャンル名
	 */
	public String getName() {
		return name;
	}
	/**
	 * ジャンル名を設定します
	 * @param name 設定するジャンル名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 親のジャンルIDを取得します
	 * @return 親のジャンルID
	 */
	public String getParent_genre_id() {
		return parent_genre_id;
	}
	/**
	 * 親のジャンルIDを設定します
	 * @param parent_genre_id 設定する親のジャンルID
	 */
	public void setParent_genre_id(String parent_genre_id) {
		this.parent_genre_id = parent_genre_id;
	}

	/**
	 * 親のジャンル名を取得します
	 * @return 親のジャンル名
	 */
	public String getParent_name() {
		return parent_name;
	}

	/**
	 * 親のジャンル名を設定します
	 * @param parent_name 設定する親のジャンル名
	 */
	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}

	/**
	 * 先祖のジャンル名を取得します
	 * @return 先祖のジャンル名
	 */
	public String getGrand_name() {
		return grand_name;
	}

	/**
	 * 先祖のジャンル名を設定します
	 * @param grand_name 設定する先祖のジャンル名
	 */
	public void setGrand_name(String grand_name) {
		this.grand_name = grand_name;
	}
}
