package dmv;
//probably not done
import java.util.ArrayList;

public class Person {

	private String name, address, dob, gender, hair, eye, height, weight, note;
	private ArrayList<String> restrictions;
	
	public Person(String name, String address, String dob, String gender,
			String hair, String eye, String height, String weight,
			ArrayList<String> restrictions) 
	{
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.gender = gender;
		this.hair = hair;
		this.eye = eye;
		this.height = height;
		this.weight = weight;
		this.restrictions = restrictions;
		note = new String();
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getDob() 
	{
		return dob;
	}

	public void setDob(String dob) 
	{
		this.dob = dob;
	}

	public String getGender() 
	{
		return gender;
	}

	public void setGender(String gender) 
	{
		this.gender = gender;
	}

	public String getHair() 
	{
		return hair;
	}

	public void setHair(String hair) 
	{
		this.hair = hair;
	}

	public String getEye() 
	{
		return eye;
	}

	public void setEye(String eye) 
	{
		this.eye = eye;
	}

	public String getHeight() 
	{
		return height;
	}

	public void setHeight(String height) 
	{
		this.height = height;
	}

	public String getWeight() 
	{
		return weight;
	}

	public void setWeight(String weight) 
	{
		this.weight = weight;
	}

	public ArrayList<String> getRestrictions() 
	{
		return restrictions;
	}

	public void addRestriction(String r) 
	{
		restrictions.add(r);
	}
	
	public void setRestrictions(ArrayList<String> r)
	{
		restrictions = r;
	}
	
	public void clearRestrictions()
	{
		restrictions.clear();
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() 
	{
		
		String r = "";
		
		for(String x : restrictions)
			r += x + ", ";
		
		return "Name = " + name + ",   Address = " + address + ",   DoB = " + dob
				+ ", \nGender = " + gender + ",   Hair Color = " + hair + ",   Eye Color = " + eye
				+ ", \nHeight = " + height + ",   Weight = " + weight + " lbs"
				+ ",   Restrictions = " + r + " Note = " + note;
	}
	
	
	
}
