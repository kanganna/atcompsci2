package magazine;

import java.util.Stack;

public class MagazineRack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MagazineList rack = new MagazineList();
		Stack<String> x = new Stack<String>();
		x.add("1");
		x.add("2");
		x.add("3");
		x.add("4");
		System.out.println(x);
		System.out.println("Popping: " + x.pop());
		System.out.println(x);
		System.out.println("First: " + x.peek());
		x.push("FIRST");
		System.out.println(x);
		System.out.println("First: " + x.peek());
		System.out.println("Size: " + x.size());
		
	}

}
