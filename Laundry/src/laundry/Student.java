package laundry;

public class Student {

	private String first, last;
	
	public Student(String f, String l)
	{
		first = f;
		last = l;
	}
	
	public String getName()
	{
		return last + ", " + first;
	}
}
