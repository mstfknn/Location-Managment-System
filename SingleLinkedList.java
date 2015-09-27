import enigma.core.Enigma;



public class SingleLinkedList {
	PlaceTypeNode head;
	int ID=1;
	int y =5;
	public static enigma.console.Console cn = Enigma.getConsole("Cng" , 120 ,40, true);
	public void add(PlaceType p1){							//for add placetypes
		PlaceTypeNode newnode =new PlaceTypeNode(p1);
		if(head==null){
			head=newnode;
			head.getPlacetype().setID(ID);;
			ID++;

		}
		else{
			PlaceTypeNode temp=head;
			while(temp.getNext()!=null){

				temp=temp.getNext();

			}
			temp.setNext(newnode);
			temp=temp.getNext();
			temp.getPlacetype().setID(ID);
			ID++;
		}
	}
	public void del(int ID){								//for delete placetypes
		PlaceTypeNode temp=head;
		if(head.getPlacetype().getID()==ID){
			head=head.getNext();
		}
		else{
			PlaceTypeNode prev=temp;
			while(temp!=null&&temp.getPlacetype().getID()!=ID){
				prev=temp;
				temp=temp.getNext();
			}
			if(temp!=null){
				prev.setNext(temp.getNext());
			}
		}


	}
	public void display(){									//for display placetypes
		PlaceTypeNode temp=head;
		while(temp!=null){
			cn.getTextWindow().setCursorPosition(140, y);
			System.out.println(temp.getPlacetype().getID()+"-"+temp.getPlacetype().getName());
			temp=temp.getNext();
			y++;
		}
		y=5;
	}
	public int sizePlacetype(){  							//for size placetypes
		int count=0;
		PlaceTypeNode temp=head;
		while(temp!=null){
			count++;
			temp=temp.getNext();
		}
		return count;
	}
}

