import enigma.core.Enigma;


public class MultiLinkedList2 {
	PersonNode head;
	int y =5;
	int x=5;
	int z=22;
	int t=22;
	public static enigma.console.Console cn = Enigma.getConsole("Cng" , 120 ,40, true);
	int personID=1;
	MultiLinkedList1 mll1=new MultiLinkedList1();
	public void add(Person pr){											//for add person

		PersonNode newnode=new PersonNode(pr);
		if(head==null){
			head=newnode;
			head.getPerson().setPersonId(personID);
			personID++;
		}
		else{

			PersonNode temp=head;
			while(temp.getNext()!=null){

				temp=temp.getNext();
			}
			temp.setNext(newnode);
			temp=temp.getNext();
			temp.getPerson().setPersonId(personID);
			personID++;

		}
	}
	public void delPerson(int personID){								//for delete person
		PersonNode temp=head;

		if(head.getPerson().getPersonId()==personID){
			head=head.getNext();
		} 
		else{
			PersonNode prev=temp;
			while(temp!=null&&temp.getPerson().getPersonId()!=personID){
				prev=temp;
				temp=temp.getNext();
			}
			if(temp!=null){
				prev.setNext(temp.getNext());
			}
		}




	}
	public void PersonDetails(int personID){							//for person details
		PersonNode temp=head;

		while(temp!=null&&temp.getPerson().getPersonId()!=personID){
			temp=temp.getNext();
		}
		PersonNode temp2=temp.getUp();
		if(temp!=null){
			cn.getTextWindow().setCursorPosition(110, t);
			System.err.println("Name: "+temp.getPerson().getName()+" "+temp.getPerson().getSurname());
			cn.getTextWindow().setCursorPosition(110, t+1);
			System.out.println("ID: "+temp.getPerson().getPersonId());
			cn.getTextWindow().setCursorPosition(110, t+2);
			System.out.println("Friends:");
			while(temp2!=null){
				cn.getTextWindow().setCursorPosition(118, t+3);
				System.out.println(temp2.getPerson().getName()+" "+temp2.getPerson().getSurname());
				temp2=temp2.getNext();
				t++;
			}
			t=22;
		}




	}
	public void displayPerson(){										//for display person
		PersonNode temp=head;

		while(temp!=null){

			cn.getTextWindow().setCursorPosition(110, y);
			System.out.println(temp.getPerson().getPersonId()+"-"+temp.getPerson().getName()+" "+temp.getPerson().getSurname());
			temp=temp.getNext();

			y++;

		}

		y=5;
	}
	public void addFriend(int personID, int friendID){					//for add friends
		PersonNode temp=head;


		while(temp!=null&&temp.getPerson().getPersonId()!=personID){
			temp=temp.getNext();
		}
		PersonNode temp1=head;
		while(temp1!=null&&temp1.getPerson().getPersonId()!=friendID){
			temp1=temp1.getNext();
		}


		Person p=new Person(temp1.getPerson().getName(),temp1.getPerson().getSurname());

		PersonNode temp2=temp.getUp();


		if(temp2==null){
			temp2=new PersonNode(p);
			temp.setUp(temp2);
		}
		else{
			PersonNode newnode=new PersonNode(p);
			while(temp2.getNext()!=null){
				temp2=temp2.getNext();
			}
			temp2.setNext(newnode);
			temp2=newnode;
		}

	}
	public void displayFriend(int personID){							//for display friends
		PersonNode temp=head;
		while(temp!=null&&temp.getPerson().getPersonId()!=personID){

			temp=temp.getNext();
		}

		PersonNode temp2=temp.getUp();

		while(temp2!=null){
			cn.getTextWindow().setCursorPosition(80, z);
			z++;
			System.out.println(temp2.getPerson().getName()+" "+temp2.getPerson().getSurname());
			temp2=temp2.getNext();
		}
		z = 22;
	}
	public  void Checkin(MultiLinkedList1 mll1, int personID, int placeID, int hour, int day){				//for checkin

		Checkin c=new Checkin(personID, placeID, hour, day);
		PersonNode temp=head;
		Place place = mll1.search(placeID);


		while(temp!=null&&temp.getPerson().getPersonId()!=personID){
			temp=temp.getNext();}



		temp.getPerson().setCoordx(mll1.xýd(placeID));
		temp.getPerson().setCoordy(mll1.yýd(placeID));

		place.setPerson(temp.getPerson());
		CheckinNode temp2=temp.getDown();

		if(temp2==null){
			temp2=new CheckinNode(c);
			temp.setDown(temp2);
		}
		else{
			CheckinNode newnode=new CheckinNode(c);
			while(temp2.getNext()!=null){
				temp2=temp2.getNext();
			}
			temp2.setNext(newnode);
			temp2=newnode;
		}

		cn.getTextWindow().setCursorPosition(mll1.xýd(placeID)+2,mll1.yýd(placeID)+5);
		int d=mll1.sizes(placeID-1)+1;
		System.out.println(d);
	}
	public Person search(int personID){									//for person search
		PersonNode temp = head;
		while(temp != null){
			if(temp.getPerson().getPersonId() == personID){
				return temp.getPerson();
			}
			temp = temp.getNext();
		}
		return null;
	}
	public void display(int personID)									//for display person
	{
		if(head == null)
		{
			System.out.println("No Checkin");
		}

		else
		{
			PersonNode temp = head;

			while(temp != null)
			{
				if(personID == temp.getPerson().getPersonId())
				{
					CheckinNode temp2 = temp.getDown();
					while(temp2 != null)
					{
						cn.getTextWindow().setCursorPosition(170, x);
						System.out.println("Person ID: "+temp2.getCheckin().getPersonID());
						cn.getTextWindow().setCursorPosition(170, x+1);
						System.out.println("Place ID: " +temp2.getCheckin().getPlaceID());
						cn.getTextWindow().setCursorPosition(170, x+2);
						System.out.println("Hour: " +temp2.getCheckin().getHour());
						cn.getTextWindow().setCursorPosition(170, x+3);
						System.out.println("Date: " +temp2.getCheckin().getDay()+".01.2015");

						temp2 = temp2.getNext();
						x=x+4;
					}
					x=5;
				}
				temp = temp.getNext();
			}
		}
	}
	public String Person (int a){
		PersonNode temp = head;
		while(temp != null){
			if(temp.getPerson().getPersonId()== a){
				return temp.getPerson().getName()+" "+temp.getPerson().getSurname();
			}
			temp=temp.getNext();
		}
		return null;
	}
	public int sizePerson(){											//for size person
		int count=0;
		PersonNode temp=head;
		while(temp!=null){
			count++;
			temp=temp.getNext();
		}
		return count;
	}

}





