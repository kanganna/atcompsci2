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
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		
		return this.getName().equals(((Student)obj).getName());
	}
}
