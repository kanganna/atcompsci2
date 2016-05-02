package p9_6;

import java.util.Queue;

public class Customer {

	private int pick;
	private Line x;
	
	public Customer(Line a, Line b, Line c, Line d)
	{
		if(a.length() < b.length())
		{
			pick = a.length();
			x = a;
		}
		else
		{
			pick = b.length();
			x = b;
		}
		if(pick > c.length())
		{
			pick = c.length();
			x = c;
		}
		if(pick > d.length())
		{
			pick = d.length();
			x = d;
		}
	}
	
	public Customer()
	{
		
	}
	
	public Line queue()
	{
		return x;
	}
}
