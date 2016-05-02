package p9_6;

import java.util.LinkedList;


public class Line extends LinkedList<Customer> {
	
	private int length = 0;
	private String name = "";
	
	public Line(String x)
	{
		name = x;
	}
	
	public String name()
	{
		return name;
	}
	
	public String arrive()
	{
		length++;
		add(new Customer());
		return "\nCustomer arrived at " + name + ".";
	}
	
	public String finished()
	{
		if(!isEmpty())
		{
			this.removeFirst();
			length--;
			return "Customer finished at " + name + ".";
		}
		return "";
	}
	public int length()
	{
		return length;
	}
	
	public String toString()
	{
		return name;
	}

}
