
public class CCA extends ccaCategory {//Made by Sean

	private String cca_title;
	private String description;
	private int class_size;
	private String cca_day_of_the_week;
	private int time;
	private String venue;
	
	public CCA(String title, int id, String cca_title, String description, int class_size, String cca_day_of_the_week,
			int time, String venue) {
		super(title, id);
		this.cca_title = cca_title;
		this.description = description;
		this.class_size = class_size;
		this.cca_day_of_the_week = cca_day_of_the_week;
		this.time = time;
		this.venue = venue;
	}

	public String getCca_title() {
		return cca_title;
	}

	public void setCca_title(String cca_title) {
		this.cca_title = cca_title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getClass_size() {
		return class_size;
	}

	public void setClass_size(int class_size) {
		this.class_size = class_size;
	}

	public String getCca_day_of_the_week() {
		return cca_day_of_the_week;
	}

	public void setCca_day_of_the_week(String cca_day_of_the_week) {
		this.cca_day_of_the_week = cca_day_of_the_week;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	
}
