


import java.awt.event.KeyEvent;

import enigma.core.Enigma;
import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import enigma.console.TextAttributes;

import java.awt.Color;


import java.awt.event.KeyListener;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

import enigma.console.Console;
import enigma.console.TextAttributes;
import enigma.core.Enigma;
public class Management {
	public static enigma.console.Console cn = Enigma.getConsole("Ceng Square" , 190 ,40, false);
	public static char[][] arr=new char[50][50];
	public static String[] words = null;
	public static int day = 1; 
	private static TextAttributes blue = new TextAttributes(Color.CYAN, Color.CYAN);
	private static TextAttributes blue2 = new TextAttributes(Color.CYAN, Color.BLACK);
	private static TextAttributes black1 = new TextAttributes(Color.WHITE, Color.BLACK);
	private static TextAttributes red = new TextAttributes(Color.RED, Color.RED);
	private static TextAttributes red2 = new TextAttributes(Color.RED, Color.BLACK);
	private static TextAttributes red3 = new TextAttributes(Color.WHITE, Color.RED);
	private static TextAttributes red4 = new TextAttributes(Color.RED, Color.WHITE); 
	private static TextAttributes orange = new TextAttributes(Color.ORANGE, Color.ORANGE);
	private static TextAttributes orange2 = new TextAttributes(Color.ORANGE, Color.BLACK);
	private static TextAttributes orange3 = new TextAttributes(Color.BLACK, Color.ORANGE);	
	private static TextAttributes green = new TextAttributes(Color.GREEN, Color.BLACK);
	private static TextAttributes green2 = new TextAttributes(Color.BLACK, Color.GREEN);
	private static TextAttributes pink = new TextAttributes(Color.PINK); 
	private static TextAttributes black = new TextAttributes(Color.BLACK, Color.WHITE); 
	private static TextAttributes gray = new TextAttributes(Color.GRAY, Color.GRAY); 
	private static TextAttributes white = new TextAttributes(Color.BLACK, Color.WHITE); 
	SingleLinkedList sll = new SingleLinkedList(); 
	MultiLinkedList1 mll1=new MultiLinkedList1();
	MultiLinkedList2 mll2=new MultiLinkedList2();
	public TextMouseListener tmlis; 
	public KeyListener klis; 
	public int mousepr;          // mouse pressed?
	public int mousex, mousey;   // mouse text coords.
	public int keypr;   // key pressed?
	public int rkey;    // key   (for press/release)
	int a=3;
	public static int i=5;
	public Management() throws IOException, InterruptedException{

		tmlis=new TextMouseListener() {
			public void mouseClicked(TextMouseEvent arg0) {}
			public void mousePressed(TextMouseEvent arg0) {
				if(mousepr==0) {
					mousepr=1;
					mousex=arg0.getX();
					mousey=arg0.getY();
				}
			}
			public void mouseReleased(TextMouseEvent arg0) {}
		};
		cn.getTextWindow().addTextMouseListener(tmlis);

		klis=new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				if(keypr==0) {
					keypr=1;
					rkey=e.getKeyCode();
				}
			}
			public void keyReleased(KeyEvent e) {}
		};
		cn.getTextWindow().addKeyListener(klis);
		mapop();
		Screen();
		Menu();


	}
	public void drawMap(){										//for map color 



		cn.getTextWindow().setCursorPosition(0,3);
		cn.setTextAttributes(black);
		for (int i = 0; i < 21; i++) {

			for (int j = 0; j < 43; j++) {

				if(arr[i][j] == '#'){
					cn.getTextWindow().output('#', gray);
				}
				else if(arr[i][j] == '.'){
					cn.getTextWindow().output('.',white);
				}

				else if(arr[i][j] == '1'){
					cn.getTextWindow().output('1');
				}
				else if(arr[i][j] == '2'){
					cn.getTextWindow().output('2');
				}
				else if(arr[i][j] == '3'){
					cn.getTextWindow().output('3');
				}
				else if(arr[i][j] == '4'){
					cn.getTextWindow().output('4');
				}
				else if(arr[i][j] == '5'){
					cn.getTextWindow().output('5');
				}
				else if(arr[i][j] == '6'){
					cn.getTextWindow().output('6');
				}
				else if(arr[i][j] == '7'){
					cn.getTextWindow().output('7');
				}
				else if(arr[i][j] == '8'){
					cn.getTextWindow().output('8');
				}
				else if(arr[i][j] == '9'){
					cn.getTextWindow().output('9');
				}
				else if(arr[i][j] == '0'){
					cn.getTextWindow().output('0');
				}
				else if(arr[i][j] == ' '){
					cn.getTextWindow().output(' ');
				}
				else if(arr[i][j]=='x'){
					cn.getTextWindow().output('x', red3);
				}


			}

			cn.setTextAttributes(black);

			System.out.println("");

		}

	}
	public void Menu() throws IOException, InterruptedException{//for screen details and inputs



		Scanner scn=new Scanner(System.in);
		String input;

		do{


			mll1.displayPlace();
			mll2.displayPerson();
			sll.display();
			cn.getTextWindow().setCursorPosition(6, 26);
			System.out.print("                                     ");
			cn.getTextWindow().setCursorPosition(0, 26);

			System.out.print("command > ");
			i++;

			input=scn.nextLine();


			i++;
			String[] word=input.split(" ");
			if(word[0].equals("placetype")&&word[1].equals("add")){
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 5+i);
					System.out.print("                                                                                                             ");

				}
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 22+i);
					System.out.print("                                                                                                             ");

				}
				PlaceType p=new PlaceType(word[2],word[3]);
				sll.add(p);
			}
			else if(word[0].equals("placetype")&&word[1].equals("del")){
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 5+i);
					System.out.print("                                                                                                             ");

				}
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 22+i);
					System.out.print("                                                                                                             ");

				}
				sll.del(Integer.valueOf(word[2]));


			}
			else if(word[0].equals("placetype")&&word[1].equals("list")){
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 5+i);
					System.out.print("                                                                                                             ");

				}
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 22+i);
					System.out.print("                                                                                                             ");

				}
				sll.display();
			}

			else if(word[0].equals("place")&&word[1].equals("add")){
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 5+i);
					System.out.print("                                                                                                             ");

				}
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 22+i);
					System.out.print("                                                                                                             ");

				}
				Place p=new Place(word[2],Integer.valueOf(word[3]),Integer.valueOf(word[4]),Integer.valueOf(word[5]));

				mll1.addPlace(p);
			}


			else if(word[0].equals("place")&&word[1].equals("list")){
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 5+i);
					System.out.print("                                                                                                             ");

				}
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 22+i);
					System.out.print("                                                                                                             ");

				}
				mll1.displayPlace();
			}
			else if(word[0].equals("place")&&word[1].equals("del")){
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 5+i);
					System.out.print("                                                                                                             ");

				}
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 22+i);
					System.out.print("                                                                                                             ");

				}
				mll1.delPlace(Integer.valueOf(word[2]));
			}
			else if(word[0].equals("place")&&word[1].equals("details")){
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 5+i);
					System.out.print("                                                                                                             ");

				}
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 22+i);
					System.out.print("                                                                                                             ");

				}
				mll1.PlaceDetails(Integer.valueOf(word[2]));
			}
			else if(word[0].equals("prsn")&&word[1].equals("add")&&word[2].equals("friend")){
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 5+i);
					System.out.print("                                                                                                             ");

				}
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 22+i);
					System.out.print("                                                                                                             ");

				}

				mll2.addFriend(Integer.valueOf(word[3]),Integer.valueOf(word[4]));
			}
			else if(word[0].equals("prsn")&&word[1].equals("list")&&word[2].equals("friend")){
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 5+i);
					System.out.print("                                                                                                             ");

				}
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 22+i);
					System.out.print("                                                                                                             ");

				}

				mll2.displayFriend(Integer.valueOf(word[3]));
			}

			else if(word[0].equals("person")&&word[1].equals("add")){
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 5+i);
					System.out.print("                                                                                                             ");

				}
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 22+i);
					System.out.print("                                                                                                             ");

				}
				Person pr=new Person(word[2],word[3]);
				mll2.add(pr);
			}
			else if(word[0].equals("person")&&word[1].equals("list")){
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 5+i);
					System.out.print("                                                                                                             ");

				}
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 22+i);
					System.out.print("                                                                                                             ");

				}
				mll2.displayPerson();}



			else if(word[0].equals("person")&&word[1].equals("del")){
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 5+i);
					System.out.print("                                                                                                             ");

				}
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 22+i);
					System.out.print("                                                                                                             ");

				}

				mll2.delPerson(Integer.valueOf(word[2]));

			}


			else if(word[0].equals("person")&&word[1].equals("details")){
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 5+i);
					System.out.print("                                                                                                             ");

				}
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 22+i);
					System.out.print("                                                                                                             ");

				}

				mll2.PersonDetails(Integer.valueOf(word[2]));
			}
			else if(word[0].equals("checkin")&&word[1].equals("add")){
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 5+i);
					System.out.print("                                                                                                             ");

				}
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 22+i);
					System.out.print("                                                                                                             ");

				}

				mll2.Checkin(mll1, Integer.valueOf(word[2]), Integer.valueOf(word[3]),Integer.valueOf(word[4]),day);

				Checkin prc = new Checkin(Integer.valueOf(word[2]), Integer.valueOf(word[3]),Integer.valueOf(word[4]),day);
				prc.setPlacename(mll1.Place(Integer.valueOf(word[3])));
				int x = mll1.xýd(Integer.valueOf(word[3]));
				int y = mll1.yýd(Integer.valueOf(word[3]));
				if(x == -1 || y == -1){
					System.out.println("Error");
				}else{
					Person person = mll2.search(Integer.valueOf(word[2]));
					if(person != null){
						person.setCheckin(prc);
						person.setCoordx(x);
						person.setCoordy(y);
						mll1.Person(person);
					}
				}

			}
			else if(word[0].equals("checkin")&&word[1].equals("list")){
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 5+i);
					System.out.print("                                                                                                             ");

				}
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 22+i);
					System.out.print("                                                                                                             ");

				}
				mll2.display(Integer.valueOf(word[2]));
			}
			else if(word[0].equals("load")){
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 5+i);
					System.out.print("                                                                                                             ");

				}
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 22+i);
					System.out.print("                                                                                                             ");

				}
				File(word[1]);
			}
			else if (word[0].equals("nextday")){
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 5+i);
					System.out.print("                                                                                                             ");

				}
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 22+i);
					System.out.print("                                                                                                             ");

				}
				mll1.nextday();
				day++;
				cn.getTextWindow().setCursorPosition(0, 0);
				System.out.println("Date:"+day+".01.2015");
			}
			else if (word[0].equals("popular")&&word[1].equals("place")){
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 5+i);
					System.out.print("                                                                                                             ");

				}
				for (int i = 0; i < 14; i++) {
					cn.getTextWindow().setCursorPosition(80, 22+i);
					System.out.print("                                                                                                             ");

				}
				mll1.popularplacetype();
			}

			else{



			}


			i++;



		}while(a==3);
	}
	public void Screen() throws IOException{                    //screen details

		cn.getTextWindow().setCursorPosition(0, 0);
		System.out.println("Date:"+day+".01.2015");
		cn.getTextWindow().setCursorPosition(80, 3);
		System.out.println("PLACE LÝST");
		cn.getTextWindow().setCursorPosition(110, 3);
		System.out.println("PERSON LÝST");
		cn.getTextWindow().setCursorPosition(140, 3);
		System.out.println("PLACETYPE LÝST");
		cn.getTextWindow().setCursorPosition(170, 3);
		System.out.println("CHECKIN LÝST");
		cn.getTextWindow().setCursorPosition(80, 20);
		System.out.println("PERSON LÝST FRIEND");
		cn.getTextWindow().setCursorPosition(110, 20);
		System.out.println("PERSON DETAILS");
		cn.getTextWindow().setCursorPosition(140, 20);
		System.out.println("PLACE/POSITION DETAILS");
		cn.getTextWindow().setCursorPosition(50,3);
		System.out.println("COMMANDS");
		cn.getTextWindow().setCursorPosition(50,5);
		System.out.println("placetype add");
		cn.getTextWindow().setCursorPosition(50,6);
		System.out.println("placetype list");
		cn.getTextWindow().setCursorPosition(50,7);
		System.out.println("placetype del");
		cn.getTextWindow().setCursorPosition(50,10);
		System.out.println("place add");
		cn.getTextWindow().setCursorPosition(50,11);
		System.out.println("place list");
		cn.getTextWindow().setCursorPosition(50,12);
		System.out.println("place del");
		cn.getTextWindow().setCursorPosition(50,13);
		System.out.println("place details");
		cn.getTextWindow().setCursorPosition(50,16);
		System.out.println("person add");
		cn.getTextWindow().setCursorPosition(50,17);
		System.out.println("person list");
		cn.getTextWindow().setCursorPosition(50,18);
		System.out.println("person del");
		cn.getTextWindow().setCursorPosition(50,19);
		System.out.println("person details");
		cn.getTextWindow().setCursorPosition(50,22);
		System.out.println("prsn add friend");
		cn.getTextWindow().setCursorPosition(50,23);
		System.out.println("prsn list friend");
		cn.getTextWindow().setCursorPosition(50,26);
		System.out.println("checkin add");
		cn.getTextWindow().setCursorPosition(50,27);
		System.out.println("checkin  list");
		cn.getTextWindow().setCursorPosition(50,30);
		System.out.println("position details");
		cn.getTextWindow().setCursorPosition(50,33);
		System.out.println("load");
		cn.getTextWindow().setCursorPosition(50,34);
		System.out.println("nextday");
		cn.getTextWindow().setCursorPosition(0,3);
		cn.setTextAttributes(black);
		cn.setTitle("Ceng Square");

		drawMap();


	}
	public void File(String word) throws IOException{           //for file operations

		String path = word +".txt";

		try{
			File file = new File(path);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;

			while((line = bufferedReader.readLine())!= null){
				fileList(line);
			}
			fileReader.close();

		}
		catch(IOException e){
			e.printStackTrace();
		}




	}
	public void fileList(String input){							//for file commands

		String[] word=input.split(" ");
		if(word[0].equals("placetype")&&word[1].equals("add")){
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 5+i);
				System.out.print("                                                                                                             ");

			}
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 22+i);
				System.out.print("                                                                                                             ");

			}
			PlaceType p=new PlaceType(word[2],word[3]);
			sll.add(p);
		}
		else if(word[0].equals("placetype")&&word[1].equals("del")){
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 5+i);
				System.out.print("                                                                                                             ");

			}
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 22+i);
				System.out.print("                                                                                                             ");

			}
			sll.del(Integer.valueOf(word[2]));


		}
		else if(word[0].equals("placetype")&&word[1].equals("list")){
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 5+i);
				System.out.print("                                                                                                             ");

			}
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 22+i);
				System.out.print("                                                                                                             ");

			}
			sll.display();
		}

		else if(word[0].equals("place")&&word[1].equals("add")){
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 5+i);
				System.out.print("                                                                                                             ");

			}
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 22+i);
				System.out.print("                                                                                                             ");

			}
			Place p=new Place(word[2],Integer.valueOf(word[3]),Integer.valueOf(word[4]),Integer.valueOf(word[5]));

			mll1.addPlace(p);
		}


		else if(word[0].equals("place")&&word[1].equals("list")){
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 5+i);
				System.out.print("                                                                                                             ");

			}
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 22+i);
				System.out.print("                                                                                                             ");

			}
			mll1.displayPlace();
		}
		else if(word[0].equals("place")&&word[1].equals("del")){
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 5+i);
				System.out.print("                                                                                                             ");

			}
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 22+i);
				System.out.print("                                                                                                             ");

			}
			mll1.delPlace(Integer.valueOf(word[2]));
		}
		else if(word[0].equals("place")&&word[1].equals("details")){
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 5+i);
				System.out.print("                                                                                                             ");

			}
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 22+i);
				System.out.print("                                                                                                             ");

			}
			mll1.PlaceDetails(Integer.valueOf(word[2]));
		}
		else if(word[0].equals("prsn")&&word[1].equals("add")&&word[2].equals("friend")){
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 5+i);
				System.out.print("                                                                                                             ");

			}
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 22+i);
				System.out.print("                                                                                                             ");

			}

			mll2.addFriend(Integer.valueOf(word[3]),Integer.valueOf(word[4]));
		}
		else if(word[0].equals("prsn")&&word[1].equals("list")&&word[2].equals("friend")){
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 5+i);
				System.out.print("                                                                                                             ");

			}
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 22+i);
				System.out.print("                                                                                                             ");

			}

			mll2.displayFriend(Integer.valueOf(word[3]));
		}

		else if(word[0].equals("person")&&word[1].equals("add")){
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 5+i);
				System.out.print("                                                                                                             ");

			}
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 22+i);
				System.out.print("                                                                                                             ");

			}
			Person pr=new Person(word[2],word[3]);
			mll2.add(pr);
		}
		else if(word[0].equals("person")&&word[1].equals("list")){
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 5+i);
				System.out.print("                                                                                                             ");

			}
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 22+i);
				System.out.print("                                                                                                             ");

			}
			mll2.displayPerson();}



		else if(word[0].equals("person")&&word[1].equals("del")){
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 5+i);
				System.out.print("                                                                                                             ");

			}
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 22+i);
				System.out.print("                                                                                                             ");

			}

			mll2.delPerson(Integer.valueOf(word[2]));

		}


		else if(word[0].equals("person")&&word[1].equals("details")){
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 5+i);
				System.out.print("                                                                                                             ");

			}
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 22+i);
				System.out.print("                                                                                                             ");

			}

			mll2.PersonDetails(Integer.valueOf(word[2]));
		}
		else if(word[0].equals("checkin")&&word[1].equals("add")){
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 5+i);
				System.out.print("                                                                                                             ");

			}
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 22+i);
				System.out.print("                                                                                                             ");

			}

			mll2.Checkin(mll1, Integer.valueOf(word[2]), Integer.valueOf(word[3]),Integer.valueOf(word[4]),day);

			Checkin prc = new Checkin(Integer.valueOf(word[2]), Integer.valueOf(word[3]),Integer.valueOf(word[4]),day);
			prc.setPlacename(mll1.Place(Integer.valueOf(word[3])));
			int x = mll1.xýd(Integer.valueOf(word[3]));
			int y = mll1.yýd(Integer.valueOf(word[3]));
			if(x == -1 || y == -1){
				System.out.println("Error");
			}else{
				Person person = mll2.search(Integer.valueOf(word[2]));
				if(person != null){
					person.setCheckin(prc);
					person.setCoordx(x);
					person.setCoordy(y);
					mll1.Person(person);
				}
			}

		}
		else if(word[0].equals("checkin")&&word[1].equals("list")){
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 5+i);
				System.out.print("                                                                                                             ");

			}
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 22+i);
				System.out.print("                                                                                                             ");

			}
			mll2.display(Integer.valueOf(word[2]));
		}

		else if (word[0].equals("nextday")){
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 5+i);
				System.out.print("                                                                                                             ");

			}
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 22+i);
				System.out.print("                                                                                                             ");

			}
			mll1.nextday();
			day++;
			cn.getTextWindow().setCursorPosition(0, 0);
			System.out.println("Date:"+day+".01.2015");
		}
		else if (word[0].equals("popular")&&word[1].equals("place")){
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 5+i);
				System.out.print("                                                                                                             ");

			}
			for (int i = 0; i < 14; i++) {
				cn.getTextWindow().setCursorPosition(80, 22+i);
				System.out.print("                                                                                                             ");

			}
			mll1.popularplacetype();
		}

		else{



		}



	}
	public void mapop(){                                        //for map
		try {
			String line;
			int i = 0;
			FileInputStream fis = new FileInputStream("city.txt");
			DataInputStream dStream = new DataInputStream(fis);
			BufferedReader bReader = new BufferedReader(new InputStreamReader( dStream));
			line = bReader.readLine();
			while (line != null) {
				for (int j = 0; j < line.length(); j++) {
					if(line.substring(j, j+1).equals("#"))
						arr[i][j] = '#';
					else if(line.substring(j, j+1).equals("1"))
						arr[i][j] = '1';
					else if(line.substring(j, j+1).equals("2"))
						arr[i][j] = '2';
					else if(line.substring(j, j+1).equals("3"))
						arr[i][j] = '3';
					else if(line.substring(j, j+1).equals("4"))
						arr[i][j] = '4';
					else if(line.substring(j, j+1).equals("5"))
						arr[i][j] = '5';
					else if(line.substring(j, j+1).equals("6"))
						arr[i][j] = '6';
					else if(line.substring(j, j+1).equals("7"))
						arr[i][j] = '7';
					else if(line.substring(j, j+1).equals("8"))
						arr[i][j] = '8';
					else if(line.substring(j, j+1).equals("9"))
						arr[i][j] = '9';
					else if(line.substring(j, j+1).equals("0"))
						arr[i][j] = '0';
					else if(line.substring(j, j+1).equals(" "))
						arr[i][j]=' ';

					else 
						arr[i][j]='.';
				}
				i++;
				line = bReader.readLine();
			}
			fis.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}



}


