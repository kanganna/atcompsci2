package library;

import java.util.ArrayList;

public class Student extends Information
{
	private double money;

	public Student(String first, String last, String id, double money, ArrayList<Item> items) 
	{
		super(first, last, id, items);
		this.money = money;
	}
	
	public void checkOut(Item x)
	{
		super.checkOut(x);
		if(x.getFacilities() != Facilities.COMPUTER)
			money -= 5;
		
	}

	public String toString()
	{
		String[] x = super.toString().split("\\s+[ (?<!:)]");
		String rest = "";
		for(int i = 3; i < x.length; i++)
			rest += x[i];
			
		return x[0] + " " + " $" + money + "   " + x[1] + " " + rest;
	}
}
