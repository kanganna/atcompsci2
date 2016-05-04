package laundry;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimerTask;

public class Event extends TimerTask
{
    Student x;
    Calendar c;
    Schedule z;
    public Event(Student x, Schedule z)//, Calendar c)
    {
      this.x = x;
      this.c = new GregorianCalendar().getInstance();//c;
      this.z = z;
    }
    public void run()
    {
      //Schedule s = new Schedule();
      String a = z.getStudentReservations(x);
      String[] t = a.split(",");
      for(String z : t)
      {
    	  //System.out.println(z.split(" ")[0]);
    	  String hour = z.split(" ")[0].split(":")[0];
    	  String day = z.split(" ")[1];
    	  int day1 = 1;
    	  
    	  if(day.equals("Mon"))
    		  day1 = 2;
    	  if(day.equals("Tues"))
    		  day1 = 3;
    	  if(day.equals("Wed"))
    		  day1 = 4;
    	  if(day.equals("Thurs"))
    		  day1 = 5;
    	  if(day.equals("Fri"))
    		  day1 = 6;
    	  if(day.equals("Sat"))
    		  day1 = 7;
    	  
    	  
    	 
    	  if(c.get(Calendar.HOUR_OF_DAY) == Integer.parseInt(hour) && day1 == c.get(Calendar.DAY_OF_WEEK) 
    			  && c.get(Calendar.MINUTE) >= 7)// && c.get(Calendar.MINUTE) <= 7)
    		  System.out.println("Your appointment has been missed.");
      }
    }
}

