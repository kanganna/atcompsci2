package p9_3;

import java.util.LinkedList;

public class Selection {

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
		for(int i = 0; i < x.size() - 1; i++)
	  	{
	    		int minIndex = i;

	    		for(int j = i + 1; j < x.size(); j++)
	      			if(x.get(j) < x.get(minIndex))
	        			minIndex = j;

	    			swap(x, i, minIndex);
	  	}
	}
	
	private static void swap(LinkedList<Integer> x, int i, int j)
	{
//	  	int temp = x[i];
//	  	x[i] = x[j];
//	  	x[j] = temp;
		Integer temp = x.get(i);
		x.set(i,  x.get(j));
		x.set(j,  temp);
		
	}

}
