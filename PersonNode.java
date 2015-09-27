
public class PersonNode {
	private Person person;
	private PersonNode next;
	private PersonNode up;
	private CheckinNode down;
	public PersonNode(Person person) {
		this.person=person;
		next = null;
		up = null;
		down = null;
	}
	public PersonNode getNext() {
		return next;
	}
	public void setNext(PersonNode next) {
		this.next = next;
	}
	public PersonNode getUp() {
		return up;
	}
	public void setUp(PersonNode up) {
		this.up = up;
	}
	public CheckinNode getDown() {
		return down;
	}
	public void setDown(CheckinNode down) {
		this.down = down;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

}
