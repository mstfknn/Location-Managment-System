
public class CheckinNode {
	private CheckinNode next;
	private Checkin checkin;
	public CheckinNode(Checkin checkin) {

		next = null;
		this.checkin = checkin;
	}
	public CheckinNode getNext() {
		return next;
	}
	public void setNext(CheckinNode next) {
		this.next = next;
	}
	public Checkin getCheckin() {
		return checkin;
	}
	public void setCheckin(Checkin checkin) {
		this.checkin = checkin;
	}

}
