package library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Database {
	
	private HashMap<String, Student> students;
	private HashMap<String, Teacher> teachers;
	private ArrayList<Item> items;
	
	public Database()
	{
		items = new ArrayList<Item>();
		students = new HashMap<String, Student>();
		teachers = new HashMap<String, Teacher>();
		
		try {
			setUp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void setUp() throws IOException
	{
		FileReader sReader = new FileReader("E:\\compsci\\students.txt");
		FileReader tReader = new FileReader("E:\\compsci\\teachers.txt");
		FileReader iReader = new FileReader("E:\\compsci\\database_items.txt");
		
		BufferedReader bsReader = new BufferedReader(sReader);
		BufferedReader btReader = new BufferedReader(tReader);
		BufferedReader biReader = new BufferedReader(iReader);
		
		String line;
		
		while((line = bsReader.readLine()) != null)
		{
			String[] info = line.split(" ");
			
			students.put(info[2], new Student(info[0], info[1], info[2], Integer.valueOf(info[3]), new ArrayList<Item>()));
		}
			
		bsReader.close();
		
		while((line = btReader.readLine()) != null)
		{
			String[] info = line.split(" ");
			teachers.put(info[2], new Teacher(info[0], info[1], info[2], new ArrayList<Item>()));
		}
			
		btReader.close();
		
		while((line = biReader.readLine()) != null)
		{
			String[] info = line.split("-");
			items.add(new Item(Facilities.valueOf(info[0]), info[1]));
		}
		Collections.sort(items);
	}

	public HashMap<String, Student> getStudents() {
		return students;
	}

	public HashMap<String, Teacher> getTeachers() {
		return teachers;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public String printStudents()
	{
		Iterator iterator = students.keySet().iterator();
		String s = "";
		
		while (iterator.hasNext()) 
		{
		   String key = iterator.next().toString();
		   String value = students.get(key).toString();//.replaceAll("Checked Out:", "");
		   s += value + "\n";
		   
		}
		
		return s;
	}
	
	public String printTeachers()
	{
		Iterator iterator = teachers.keySet().iterator();
		String s = "";
		
		while (iterator.hasNext()) 
		{
		   String key = iterator.next().toString();
		   String value = teachers.get(key).toString().replaceAll("Checked Out:", "");
		   s += value + "\n";
		   
		}
		
		return s;
	}

}
