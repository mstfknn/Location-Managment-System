
public class Person {
	private int personId;
	private String name;
	private String surname;
	private int coordx;
	private int coordy;
	private Checkin checkin;
	private int hour;

	private static int personCount = 0;
	public Person(String name, String surname) {
		this.personId = personCount++;
		this.name = name;
		this.surname = surname;
		this.coordx = coordx;
		this.coordy = coordy;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getCoordx() {
		return coordx;
	}
	public void setCoordx(int coordx) {
		this.coordx = coordx;
	}
	public int getCoordy() {
		return coordy;
	}
	public void setCoordy(int coordy) {
		this.coordy = coordy;
	}
	public Checkin getCheckin() {
		return checkin;
	}
	public void setCheckin(Checkin checkin) {
		this.checkin = checkin;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}

}
