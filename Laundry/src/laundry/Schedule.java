package laundry;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Queue;

public class Schedule {

	private Queue<Student> mon, tues, wed, thurs, fri, sat, sun;
	private ArrayList<Student> list;
	private Calendar c;
	
	public Schedule()
	{
		c = new GregorianCalendar().getInstance();
		
		mon = new LinkedList<Student>();
		tues = new LinkedList<Student>();
		wed = new LinkedList<Student>();
		thurs = new LinkedList<Student>();
		fri = new LinkedList<Student>();
		sat = new LinkedList<Student>();
		sun = new LinkedList<Student>();
		
		for(int i = 0; i < 24; i++)
		{
			mon.add(null);
			tues.add(null);
			wed.add(null);
			thurs.add(null);
			fri.add(null);
			sat.add(null);
			sun.add(null);
		}
		
		list = new ArrayList<Student>();
		list.add(new Student("A", "C"));
		list.add(new Student("V", "G"));
		list.add(new Student("A", "A"));
	}
	
	public void addAppointment(String day, int hour, Student x)
	{
		if(!((LinkedList<?>)getQueue(day)).contains(x))
		{
			((LinkedList<Student>)getQueue(day)).set(hour, x);
			System.out.println("Reservation made.\n");
		}
		else
			System.out.println("Only one appointment per day is allowed.\n");	
	}
	
	public boolean check(String first, String last)
	{
		Student x = new Student(first, last);
		return list.contains(x);
	}
	
	public String printQueue(String day)
	{
		return printQueue(getQueue(day));
	}
	
	private String printQueue(Queue<Student> q)
	{
		String s = ""; int z = 0;
		for(Student x : q)
		{
			s += z + ":00 - " + x.getName() + "\n";
			z++;
		}
		return s;
	}
	
	private Queue<Student> getQueue(String day)
	{
		if(day.equals("Mon"))
			return mon;
		if(day.equals("Tues"))
			return tues;
		if(day.equals("Wed"))
			return wed;
		if(day.equals("Thurs"))
			return thurs;
		if(day.equals("Fri"))
			return fri;
		if(day.equals("Sat"))
			return sat;
		if(day.equals("Sun"))
			return sun;
		return null;
	}
	
	public String getAvaliableSpots(String day)
	{
		String t = "";
		Queue<Student> x = getQueue(day);
		for(int i = 0; i < x.size(); i++)
		{
			if(((LinkedList<Student>)x).get(i) == null)
				t += i + ":00, ";
		}
		return t;
	}
	
	public String getStudentReservations(Student x)
	{
		String t = "";
		if(((LinkedList<Student>)mon).indexOf(x) != -1)
		{
			t += ((LinkedList<Student>)mon).indexOf(x) + ":00 Mon, ";
		}
		if(((LinkedList<Student>)tues).indexOf(x) != -1)
		{
			t += ((LinkedList<Student>)tues).indexOf(x) + ":00 Tues, ";
		}
		if(((LinkedList<Student>)wed).indexOf(x) != -1)
		{
			t += ((LinkedList<Student>)wed).indexOf(x) + ":00 Wed, ";
		}
		if(((LinkedList<Student>)thurs).indexOf(x) != -1)
		{
			t += ((LinkedList<Student>)thurs).indexOf(x) + ":00 Thurs, ";
		}
		if(((LinkedList<Student>)fri).indexOf(x) != -1)
		{
			t += ((LinkedList<Student>)fri).indexOf(x) + ":00 Fri, ";
		}
		if(((LinkedList<Student>)sat).indexOf(x) != -1)
		{
			t += ((LinkedList<Student>)sat).indexOf(x) + ":00 Sat, ";
		}
		if(((LinkedList<Student>)sun).indexOf(x) != -1)
		{
			t += ((LinkedList<Student>)sun).indexOf(x) + ":00 Sun, ";
		}
		return t;
	}
	
	public void remove(String day, int hour)
	{
		((LinkedList<?>)getQueue(day)).set(hour, null);
	}
	
	public String getTime()
	{
		
	}
	
}
