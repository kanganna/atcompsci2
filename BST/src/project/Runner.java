package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		BSTree t = new BSTree();
		
		Scanner k = new Scanner(System.in);
		Scanner x = new Scanner(new File("E:\\compsci\\list3.txt"));
		
		while(x.hasNext())
		{
			String u = x.next();
			try{
				int y = Integer.parseInt(u);
			    if(t.contains(y))
			    	System.out.println("Error: value already in tree");
			    else 
			    	t.add(y);
			}catch (NumberFormatException ex) {
			    System.out.println("Error: the value wasn't an integer");
			}
		}
		System.out.println("Enter in the value you wish to search for: ");
		Integer z = k.nextInt();
		
		/*BSTree x = new BSTree();
		x.add(new Integer(5));
		x.add(new Integer(3));
		x.add(new Integer(8));
		x.add(new Integer(0));
		x.add(new Integer(4));
		x.add(new Integer(7));
		x.add(new Integer(9));
		x.add(new Integer(1));
		x.add(new Integer(6));
		x.add(new Integer(2));*/
		System.out.println(t.search(z));
		//System.out.println();
		t.print();
	}

}
