package dmv;

import java.util.ArrayList;

public class Staff {

	private ArrayList<String> database;
	
	public Staff()
	{
		database = new ArrayList<String>();
		
	}
	
	public ArrayList<String> getDB()
	{
		return database;
	}
	
	public int check(String user, String pwd)
	{
		for(String x : database)
		{
			if(x.split(" ")[0].equals(user) && x.split(" ")[1].equals(pwd))
			{
				return 1;
			}
		}
		
		return -1;
	}
	
	public void addCredentials(String credentials)
	{
		database.add(credentials);
	}
	
	public String getMenu()
	{
		return "\n\n1) Search Drivers Licenses" + "\n2) Add Note" + "\n3) Quit";
	}
	
	public boolean isStaff()
	{
		return true;
	}
}
