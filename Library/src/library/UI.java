package library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UI {
	
	public static Scanner k = new Scanner(System.in);
	public static Database db = new Database();
	public static String w;
	public static ArrayList<String> r = new ArrayList<String>() {{ add("Room A"); add("Room B"); add("Room C");}};
	
	public static void main(String[] args)
	{
		int c = menu();
		while(c != 6)
		{
			switch(c)
			{
			case 1:
				w = "in";
				checkFacilities();
				break;
			case 2:
				w = "out";
				checkFacilities();
				break;
			case 3:
				accessDB();
				break;
			case 4:
				getComputer();
				break;
			case 5:
				getRoom();
				break;
			}
			
			c = menu();
		}
	}

	public static int menu()
	{
		System.out.println("\n\nLibrary\n");
		System.out.println("1) Check In Facilities");
		System.out.println("2) Check Out Facilities");
		System.out.println("3) Access Database");
		System.out.println("4) Get a Computer");
		System.out.println("5) Get a Room");
		System.out.println("6) Quit");
		
		int c = k.nextInt();
		k.nextLine();
		return c;
	}
	
	public static void checkFacilities()
	{
		Information x = null;
		System.out.println("\n\nEnter in ID number.");
		String id = k.nextLine();
		
		if(db.getStudents().containsKey(id))
			x = db.getStudents().get(id);
		else if(db.getTeachers().containsKey(id))
			x = db.getTeachers().get(id);
		else
			throw new NullPointerException("Invalid ID");
		if(w.equals("in"))
		{
			if(x.getItems().size() == 0)
			{
				System.out.println("\nYou have no items.");
			}
			else
			{
				System.out.println("\nReturn which item?");
				for(int i = 1; i <= x.getItems().size(); i++)
					System.out.println(i + ") " + x.getItems().get(i-1));
				
				int z = k.nextInt(); 
				k.nextLine();
				
				Item t = x.getItems().remove(z-1);
				if(t.getFacilities() != Facilities.COMPUTER ||t.getFacilities() != Facilities.ROOM)
				{
					db.getItems().add(t);
					Collections.sort(db.getItems());
				}
				if(t.getFacilities() == Facilities.ROOM)
				{
					for(int i = 0; i < r.size(); i++)
					{
						if(r.get(i).contains(t.getName()))
							r.set(i, t.getName());
					}
				}
			}
		}
		else
		{
			System.out.println("\nCheck out which item?");
			for(int i = 1; i <= db.getItems().size(); i++)
				System.out.println(i + ") " + db.getItems().get(i-1));
			
			int z = k.nextInt(); 
			k.nextLine();
			
			Item r = db.getItems().remove(z-1);
			x.checkOut(r);
		}
		
	}
	
	public static void accessDB()
	{
		System.out.println("\n\nWhat would you like to see?");
		System.out.println("1) List of Students");
		System.out.println("2) List of Teachers");
		
		int z = k.nextInt(); 
		k.nextLine();
		System.out.println("\n");
		if(z == 1)
		{
			System.out.println(db.printStudents());
		}
		if(z == 2)
			System.out.println(db.printTeachers());
	}
	
	public static void getComputer()
	{
		Information x = null;
		System.out.println("\n\nEnter in ID number.");
		String id = k.nextLine();
		
		if(db.getStudents().containsKey(id))
			x = db.getStudents().get(id);
		else if(db.getTeachers().containsKey(id))
			x = db.getTeachers().get(id);
		else
			throw new NullPointerException("Invalid ID");
		
		if(x.getItems().toString().contains("COMPUTER"))
			System.out.println("You already have a computer. Don't be greedy.");
		else
		{
			int n = (int) (Math.random() * 30 + 1);
			System.out.println("\nYou have received Computer # " + n);
			x.checkOut(new Item(Facilities.COMPUTER, "COMPUTER " + n));
		}
	}
	
	public static void getRoom()
	{
		Information x = null;
		System.out.println("\n\nEnter in ID number.");
		String id = k.nextLine();
		
		if(db.getStudents().containsKey(id))
			x = db.getStudents().get(id);
		else if(db.getTeachers().containsKey(id))
			x = db.getTeachers().get(id);
		else
			throw new NullPointerException("Invalid ID");
		
		if(x.getItems().toString().contains("ROOM"))
			System.out.println("You already have a room. Don't be greedy.");
		else
		{	
			System.out.println("Which room do you want?");
			
			for(int i = 1; i <= r.size(); i++)
			{
				System.out.println(i + ") " + r.get(i-1));
			}
			int z = k.nextInt() - 1; 
			k.nextLine();
			if(r.get(z).contains("OCCUPIED"))
				System.out.println("That room is occupied. Don't be rude.");
			else
			{
				x.checkOut(new Item(Facilities.ROOM, r.get(z)));
				r.set(z, r.get(z) + " - OCCUPIED");
			}
		}
	}
}





/* Library
 * 
 * Check In Facilities
 * Check Out Facilities
 * Access Database
*/
// it's z - 1 cause of the offset and the formatting numbering
// hashmap is non-deterministic aka iterator ordering is like random