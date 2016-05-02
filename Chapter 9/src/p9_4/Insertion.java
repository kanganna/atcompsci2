package p9_4;

import java.util.LinkedList;

public class Insertion {

	public static void main(String[] args) 
	{
		LinkedList<Integer> x = new LinkedList<Integer>();	
		x.add(1);
		x.add(6);
		x.add(2);
		x.add(6);
		x.add(7);
		x.add(6);
		sort(x);
		System.out.println(x);
	}
	
	public static void sort(LinkedList<Integer> x)
	{
	  	for (int i = 1; i < x.size(); i++)
	  	{
	    		int element = x.get(i);
	    		int j = i;
	    		while (j > 0 && element < x.get(j - 1))
	   		{
	    			x.set(j, x.get(j-1));
	      			j--;
	    		}

	    		x.set(j, element);
	  	}
	}


}
