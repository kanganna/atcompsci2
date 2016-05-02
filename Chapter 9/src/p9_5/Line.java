package p9_5;

import java.util.LinkedList;


public class Line extends LinkedList<Customer> {
	
	public String arrive()
	{
		add(new Customer());
		return "Customer arrived at queue.";
	}
	
	public String finished()
	{
		if(!isEmpty())
		{
			removeFirst();
			return "Customer finished and left the queue.";
		}
		return "";
	}
}
