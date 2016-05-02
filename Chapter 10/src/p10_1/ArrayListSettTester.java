package p10_1;

import java.util.ArrayList;

public class ArrayListSettTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayListSet<Integer> x = new ArrayListSet<Integer>();
		x.add(2);
		x.add(3);
		x.add(6);
		x.add(17);
		for(int i : x)
			System.out.print(i + " ");
		
	
		System.out.println();
		ArrayList<Integer> y = new ArrayList<Integer>();
		y.add(6);
		y.add(20);
		System.out.println(x.addAll(y));
	}

}
