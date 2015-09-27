import enigma.core.Enigma;
public class MultiLinkedList1 {
	public static enigma.console.Console cn = Enigma.getConsole("Cng" , 150 ,40, true);
	PlaceNode head;
	int placeID=1;
	int y = 5, count=0,count2=0, c=22;
	public void addPlace(Place p){                        //for add place
		PlaceNode newnode=new PlaceNode(p);
		if(head==null){

			head=newnode;
			head.getPlace().setPlaceID(placeID);
			placeID++;
		}
		else{

			PlaceNode temp=head;
			while(temp.getNext()!=null){

				temp=temp.getNext();
			}
			temp.setNext(newnode);
			temp=temp.getNext();
			temp.getPlace().setPlaceID(placeID);
			placeID++;

		}


	}
	public int xýd(int placeID){                          // for find places x coordinats
		PlaceNode temp=head;
		while(temp != null && temp.getPlace().getPlaceID()!=placeID){
			temp=temp.getNext();
		}
		if(temp == null){
			return -1;
		}
		int x =temp.getPlace().getCoordx();
		return x;
	}
	public int yýd(int placeID){						  // for find places y coordinats
		PlaceNode temp=head;
		while(temp != null && temp.getPlace().getPlaceID()!=placeID){
			temp=temp.getNext();
		}
		if(temp == null){
			return -1;
		}
		return temp.getPlace().getCoordy();
	}
	public void displayPlace(){							  // for display places

		PlaceNode temp=head;
		while(temp!=null){
			cn.getTextWindow().setCursorPosition(80, y);
			y++;
			System.out.println(temp.getPlace().getPlaceID()+"-"+temp.getPlace().getName()+"("+temp.getPlace().getPlacetypeID()+")"+" coord: "+temp.getPlace().getCoordx()+" "+temp.getPlace().getCoordy());

			temp=temp.getNext();
		}
		y=5;
	}
	public Place search(int placeID){                     // for search places
		PlaceNode temp = head;
		while(temp != null){
			if(temp.getPlace().getPlaceID() == placeID){
				return temp.getPlace();
			}
			temp = temp.getNext();
		}
		return null;
	}
	public String placesearch(int placeID){
		PlaceNode temp = head;

		while(temp != null){
			if(temp.getPlace().getPlaceID() == placeID){
				return temp.getPlace().getName();
			}
			temp = temp.getNext();
		}
		return null;
	}
	public void delPlace(int placeID){				   	 //for delete places
		PlaceNode temp=head;

		if(head.getPlace().getPlaceID()==placeID){
			head=head.getNext();
		} 
		else{
			PlaceNode prev=temp;
			while(temp!=null&&temp.getPlace().getPlaceID()!=placeID){
				prev=temp;
				temp=temp.getNext();
			}
			if(temp!=null){
				prev.setNext(temp.getNext());
			}
		}




	}
	public void PlaceDetails(int placeID){               //for places details
		PlaceNode temp=head;
		while(temp!=null&&temp.getPlace().getPlaceID()!=placeID){
			temp=temp.getNext();
		}
		if(temp!=null){
			cn.getTextWindow().setCursorPosition(140, c);
			System.out.println("Name: "+temp.getPlace().getName());
			cn.getTextWindow().setCursorPosition(140, c+1);
			System.out.println("Coordinates: "+temp.getPlace().getCoordx()+" "+temp.getPlace().getCoordy());

		}
	}
	public void Person(Person person){                   //for person
		PlaceNode temp=head;
		while(temp!=null&&temp.getPlace().getCoordx()!=person.getCoordx()&&temp.getPlace().getCoordy()!=person.getCoordy()){
			temp=temp.getNext();
		}
		PersonNode temp2=temp.getDown();
		if(temp2==null){
			temp2=new PersonNode(person);
			temp.setDown(temp2);
		}
		else{
			while(temp2.getNext()!=null){
				temp2=temp2.getNext();
			}
			PersonNode newnode=new PersonNode(person);
			temp2.setNext(newnode);
		}
	}
	public String Place (int a){
		PlaceNode temp = head;
		while(temp != null){
			if(temp.getPlace().getPlaceID() == placeID){

				return temp.getPlace().getName();
			}
			temp = temp.getNext();
		}
		return null;

	}
	public int sizePlace(){                              //for size places

		int count=0;
		PlaceNode temp=head;
		while(temp!=null){
			count++;
			temp=temp.getNext();
		}
		return count;
	}
	public int mpn(){
		int m=0;
		PlaceNode temp=head;
		while(temp!=null){
			PersonNode temp2=temp.getDown();
			while(temp2!=null){
				count++;
				temp2=temp2.getNext();
			}
			if(m<=count){
				m=count;
			}
			count=0;
			temp=temp.getNext();
		}
		System.out.println(m);
		return m;

	} 
	public int sizes(int a){                             //for all sizes
		count=0;
		PlaceNode temp=head;
		for (int i = 0; i < a; i++) {
			temp=temp.getNext();
		}
		PersonNode temp2=temp.getDown();
		if(temp2!=null){
			while(temp2!=null){
				count2++;
				temp2=temp2.getNext();
			}}
		return count2;
	}
	public void popularplacetype(){                      //for popularplacetype

		int i=0;
		while(sizes(i)!=mpn()){
			i++;
		}
		PlaceNode temp=head;
		for (int j = 0; j < i; j++) {
			temp=temp.getNext();
		}
		System.out.println(temp.getPlace().getName());
	}
	public void nextday(){                               //for nextday
		PlaceNode temp=head;
		while(temp!=null){
			PersonNode temp1=temp.getDown();
			PersonNode prev=temp1;
			if(temp1!=null){
				while(temp1!=null){
					temp.setDown(temp1.getNext());
					temp1=temp1.getNext();
				}
			}

			temp=temp.getNext();

		}
	}




}



