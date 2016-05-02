package library;

import java.util.ArrayList;

public class Runner {

	public static void main(String[] args) 
	{
		
		ArrayList<Item> x = new ArrayList<Item>();
		x.add(new Item(Facilities.BOOK, "hi"));
		x.add(new Item(Facilities.BOOK, "hello"));
		Student test = new Student("test", "text", "72891", 10, x);
		System.out.println(test);
		
	}

}
