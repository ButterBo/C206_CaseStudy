
public class ccaCategory {

	private String cat_title;
	private int cat_id;

	public ccaCategory(String title, int id) {
		this.cat_title = title;
		this.cat_id = id;

	}

	public String getCat_title() {
		return cat_title;
	}

	public void setCat_title(String cat_title) {
		this.cat_title = cat_title;
	}

	public int getCat_id() {
		return cat_id;
	}

	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
}
