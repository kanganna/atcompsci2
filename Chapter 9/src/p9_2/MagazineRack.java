package p9_2;

import java.util.Stack;

public class MagazineRack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MagazineList rack = new MagazineList();
		rack.add(new Magazine("B"));
		rack.add(new Magazine("A"));
		rack.add(new Magazine("C"));
		rack.add(new Magazine("D"));
		rack.add(new Magazine("Z"));
		rack.add(new Magazine("Y"));
		rack.add(new Magazine("F"));
		System.out.println(rack);
		
	}

}
