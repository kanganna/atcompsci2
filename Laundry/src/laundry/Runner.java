package laundry;
import java.util.Scanner;

public class Runner {

	static Scanner k = new Scanner(System.in);
	public static void main(String[] args) {

		Schedule s = new Schedule();
		Student current = null;
		
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
						int hour = 0;
						String h = k.nextLine();
						try
						{
							hour = Integer.parseInt(h);
						}
						catch(NumberFormatException e)
						{
							hour = Integer.parseInt(h.split(":")[0]);
						}
						s.addAppointment(day, hour, current);
					}
					
					if(c == 2)
					{
						System.out.println("Which reservation would you like to cancel?");
						System.out.println(s.getStudentReservations(current));
						String r = k.nextLine();
						int hour = 0;
						if(!r.split(":")[0].equals("0") && r.split(":")[0].split(" ").length == 1)
							hour = Integer.parseInt(r.split(":")[0]);
						
						String day = r.split(" ")[1];
						s.remove(day, hour);
						System.out.println("Reservation has been removed.\n");
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
