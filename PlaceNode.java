
public class PlaceNode {
	private PlaceNode next;
	private PersonNode down;
	private Place place;
	public PlaceNode(Place place) {

		next = null;
		down = null;
		this.place = place;
	}
	public PlaceNode getNext() {
		return next;
	}
	public void setNext(PlaceNode next) {
		this.next = next;
	}
	public PersonNode getDown() {
		return down;
	}
	public void setDown(PersonNode down) {
		this.down = down;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}

}
