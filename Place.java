
public class Place {
	private int placeID;
	private Person person;
	private String name;
	private PlaceType placetype;
	private int placetypeID;
	private int coordx;
	private int coordy;

	private static int placeCount = 0;

	public Place(String name, 
			int placetypeID, int coordx, int coordy) {
		this.placeID = placeCount++;
		this.person = person;
		this.name = name;
		this.placetype = placetype;
		this.placetypeID = placetypeID;
		this.coordx = coordx;
		this.coordy = coordy;
	}
	public int getPlaceID() {
		return placeID;
	}
	public void setPlaceID(int placeID) {
		this.placeID = placeID;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PlaceType getPlacetype() {
		return placetype;
	}
	public void setPlacetype(PlaceType placetype) {
		this.placetype = placetype;
	}
	public int getPlacetypeID() {
		return placetypeID;
	}
	public void setPlacetypeID(int placetypeID) {
		this.placetypeID = placetypeID;
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

}
