package library;

public class Item implements Comparable<Item>{
	
	private Facilities x;
	private String name;
	
	
	public Item(Facilities f, String s)
	{
		x = f;
		name = s;
	}
	
	public String toString()
	{
		return x + "- " + name;
	}
	
	public int compareTo(Item arg0) {
		
		return toString().compareTo(arg0.toString());
	}
	
	public Facilities getFacilities()
	{
		return x;
	}
	
	public String getName()
	{
		return name;
	}

}
