package library;

import java.util.ArrayList;

public class Information 
{
	private String first, last, id;
	private ArrayList<Item> items;

	public Information(String first, String last, String id, ArrayList<Item> items) 
	{
		this.first = first;
		this.last = last;
		this.items = items;
		this.id = id;
	}

	public String toString()
	{
		String list = "";
		for(Item x : items)
		{
			list += x + " ";
		}
		
		return last + ", " + first + " ID: " + id +  "\t Checked Out: " + list;
	}
	
	public void checkOut(Item x)
	{
		items.add(x);
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	public String getId() {
		return id;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

}
