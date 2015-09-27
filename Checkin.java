
public class Checkin {
	private int personID;
	private int placeID;
	private int hour;
	private int day;
	private String placename;

	public Checkin(int personID, int placeID, int hour, int day) {

		this.personID = personID;
		this.placeID = placeID;
		this.hour = hour;
		this.day=day;
		this.placename=placename;
	}
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public int getPlaceID() {
		return placeID;
	}
	public void setPlaceID(int placeID) {
		this.placeID = placeID;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getPlacename() {
		return placename;
	}
	public void setPlacename(String placename) {
		this.placename = placename;
	}



}
