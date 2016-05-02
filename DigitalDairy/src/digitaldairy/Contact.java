package digitaldairy;

public class Contact implements Comparable<Contact>
{
	
	private String first, last, phone, email, memo;
	
	public Contact(String first, String last, 
			String phone, String email, String memo)
	{
		this.first = first;
		this.last = last;
		this.phone = phone;
		this.email = email;
		this.memo = memo;
	}
	
	public Contact(String first, String last)
	{
		this.first = first;
		this.last = last;
		phone = "";
		email = "";
		memo = "";
	}

	public String getFirst() 
	{
		return first;
	}

	public void setFirst(String first) 
	{
		this.first = first;
	}

	public String getLast() 
	{
		return last;
	}

	public void setLast(String last) 
	{
		this.last = last;
	}

	public String getPhone() 
	{
		return phone;
	}

	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getMemo() 
	{
		return memo;
	}

	public void setMemo(String memo) 
	{
		this.memo = memo;
	}
	
	public String toString()
	{
		return last + ", " + first;
	}
	
	public int compareTo(Contact c)
	{
		if(getLast().compareTo(c.getLast()) != 0)
			return getLast().compareTo(c.getLast());
		return getFirst().compareTo(c.getFirst());
	}

}
