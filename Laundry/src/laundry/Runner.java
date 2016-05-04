package laundry;
import java.util.Scanner;

public class Runner {

	static Scanner k = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Schedule s = new Schedule();
		Student current = null;
		
		
	}
	
	public static int menu()
	{
		System.out.println("1) Log In");
		System.out.println("2) Quit");
		return Integer.parseInt(k.nextLine());
	}
	

}
