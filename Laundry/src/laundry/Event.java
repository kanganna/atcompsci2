package laundry;

public class Event extends TimerTask
{
    Student x;
    public Event(Student x)
    {
      this.x = x;
    }
    public void run()
    {
      Schedule s = new Schedule();
      Calendar c = new GregorianCalendar().getInstance();
    }
}
