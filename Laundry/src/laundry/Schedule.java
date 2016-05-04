package laundry;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Schedule {

	private Queue<Student> mon, tues, wed, thurs, fri, sat, sun;
	private ArrayList<Student> list;
	
	public Schedule()
	{
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
	}
	
	public void addAppointment(String day, int hour, Student x)
	{
		((LinkedList)getQueue(day)).set(hour, x);
		/*switch(day)
		{
		case "fri":
			((LinkedList)fri).set(hour, x);
			break;
		case "Tues":
			((LinkedList)tues).set(hour, x);
			break;
		case "Wed":
			((LinkedList)wed).set(hour, x);
			break;
		case "Thurs":
			((LinkedList)thurs).set(hour, x);
			break;
		case "Fri":
			((LinkedList)fri).set(hour, x);
			break;
		case "Sat":
			((LinkedList)sat).set(hour, x);
			break;
		case "Sun":
			((LinkedList)sun).set(hour, x);
			break;
		}*/
	}
	
	public boolean check(String first, String last)
	{
		Student x = new Student(first, last);
		return list.contains(new Student("A", "C"));
	}
	
	public String printQueue(String day)
	{
		return printQueue(getQueue(day));
		
		/*if(day.equals("fri"))
			return printQueue(fri);
		if(day.equals("Tues"))
			return printQueue(tues);
		if(day.equals("Wed"))
			return printQueue(wed);
		if(day.equals("Thurs"))
			return printQueue(thurs);
		if(day.equals("Fri"))
			return printQueue(fri);
		if(day.equals("Sat"))
			return printQueue(sat);
		if(day.equals("Sun"))
			return printQueue(sun);
		return null;*/
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
			if(((LinkedList)x).get(i) == null)
				t += i + ":00, ";
		}
		return t;
	}
	
	public String getStudentReservations(Student x)
	{
		String t = "";
		if(((LinkedList)mon).indexOf(x) != -1)
		{
			t += ((LinkedList)mon).indexOf(x) + ":00 Mon, ";
		}
		if(((LinkedList)tues).indexOf(x) != -1)
		{
			t += ((LinkedList)tues).indexOf(x) + ":00 Tues, ";
		}
		if(((LinkedList)wed).indexOf(x) != -1)
		{
			t += ((LinkedList)wed).indexOf(x) + ":00 Wed, ";
		}
		if(((LinkedList)thurs).indexOf(x) != -1)
		{
			t += ((LinkedList)thurs).indexOf(x) + ":00 Thurs, ";
		}
		if(((LinkedList)fri).indexOf(x) != -1)
		{
			t += ((LinkedList)fri).indexOf(x) + ":00 Fri, ";
		}
		if(((LinkedList)sat).indexOf(x) != -1)
		{
			t += ((LinkedList)sat).indexOf(x) + ":00 Sat, ";
		}
		if(((LinkedList)sun).indexOf(x) != -1)
		{
			t += ((LinkedList)sun).indexOf(x) + ":00 Sun, ";
		}
		return t;
	}
	
	public void remove(String day, int hour)
	{
		((LinkedList)getQueue(day)).set(hour, null);
	}
	
}
