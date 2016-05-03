package laundry;

import java.util.PriorityQueue;
import java.util.Queue;

public class Schedule {

	private Queue mon, tues, wed, thurs, fri, sat, sun;
	
	public Schedule()
	{
		mon = new PriorityQueue();
		tues = new PriorityQueue();
		wed = new PriorityQueue();
		thurs = new PriorityQueue();
		fri = new PriorityQueue();
		sat = new PriorityQueue();
		sun = new PriorityQueue();
		
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
}
