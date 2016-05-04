package laundry;
import java.util.Scanner;

public class Runner {

	static Scanner k = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Schedule s = new Schedule();
		Student current = null;
		
		//int c = menu();
		while(menu() != 2)
		{
			System.out.println("Username:");
			String first = k.nextLine();
			System.out.println("Password:");
			String last = k.nextLine();
			if(s.check(first, last))
			{ 
				current = new Student(first, last);
				
				int c = menu2();
				while(c != 3)
				{
					if(c == 1)
					{
						System.out.println("Which day do you want to reserve a spot on?");
						System.out.println("Mon, Tues, Wed, Thurs, Fri, Sat, Sun\n");
						String day = k.nextLine();
						System.out.println("\nAvaliable Hours: " + s.getAvaliableSpots(day));
						System.out.println("Enter in an hour:");
						int hour = Integer.parseInt(k.nextLine());
						s.addAppointment(day, hour, current);
					}
					
					if(c == 2)
					{
						System.out.println("Which reservation would you like to cancel?");
						System.out.println(s.getStudentReservations(current));
					}
					
					c = menu2();
				}
			}
			else
				System.out.println("Invalid username/password. Try again.");
		}
	}
	
	public static int menu()
	{
		System.out.println("1) Log In");
		System.out.println("2) Quit");
		return Integer.parseInt(k.nextLine());
	}
	
	public static int menu2()
	{
		System.out.println("1) Reserve Spot");
		System.out.println("2) Cancel Spot");
		System.out.println("3) Quit");
		return Integer.parseInt(k.nextLine());
	}

}
