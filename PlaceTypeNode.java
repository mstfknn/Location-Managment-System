
public class PlaceTypeNode {
	private PlaceTypeNode next;
	private PlaceType placetype;
	public PlaceTypeNode(PlaceType placetype) {

		this.next = next;
		this.placetype = placetype;
	}
	public PlaceTypeNode getNext() {
		return next;
	}
	public void setNext(PlaceTypeNode next) {
		this.next = next;
	}
	public PlaceType getPlacetype() {
		return placetype;
	}
	public void setPlacetype(PlaceType placetype) {
		this.placetype = placetype;
	}

}
