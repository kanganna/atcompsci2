package dmv;

public class Admin extends Staff{
	
	public Admin()
	{
		super();
		addCredentials("admin ADMIN");
	}
	
	public String getMenu()
	{
		return "\n\n1) Search Drivers License"
				+ "\n2) Add Note"
				+ "\n3) Add a Driver's License"
				+ "\n4) Edit a Driver's License"
				+ "\n5) Print List of People"
				+ "\n6) Suspend a Driver's License"
				+ "\n7) Revoke a Driver's License"
				+ "\n8) Print List of Revoked/Suspended/Expired Licenses"
				+ "\n9) Quit";
				
	}
	
	public boolean isStaff()
	{
		return false;
	}

}
