package laundry;

import java.util.LinkedList;
import java.util.Queue;

public class Schedule {

	private Queue<Student> mon, tues, wed, thurs, fri, sat, sun;
	
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
	}
	
	public void addAppointment(String day, int hour, Student x)
	{
		switch(day)
		{
		case "Mon":
			((LinkedList)mon).set(hour, x);
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
		}
	}
	
	public String getAccessCode()
	{
		return "laundry";
	}
	
	public String printQueue(String day)
	{
		if(day.equals("Mon"))
			return printQueue(mon);
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
		return null;
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
}
