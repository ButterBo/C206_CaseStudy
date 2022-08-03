
public class CCA {

	private int cca_id;
	private String name;
	private String venue;
	private String time;
	
	public CCA(int cca_id, String name, String venue, String time) {
		this.cca_id = cca_id;
		this.name = name;
		this.venue = venue;
		this.time = time;
	}

	public int getCca_id() {
		return cca_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}
