package p10_3;

import java.util.ArrayList;

public class Heap 
{
	private ArrayList<String> list;
	
	public Heap()
	{
		list = new ArrayList<String>();
		list.add(null);
	}
	
	public String toString()
	{
		return list.toString();
	}
	
	public void add(String o)
	{
		if(!list.contains(o.split(" ")[1]))
			list.add(o);
		else
		for(int i = 0; 2*i+1 < list.size(); i++)
		{
			if(o.split(" ")[1].equals(list.get(i).split(" ")[1])
					&& list.get(2*i) != null && list.get(2*i+1) != null)
			{
				list.add(o);
			}
		}
		
		/*list.add(o);
		bubbleUp();*/
	}
	
	public void removeLast()
	{
		list.remove(list.size()-1);
		bubbleDown();
	}
	
	public void removeFirst()
	{
		list.set(1, list.get(list.size() - 1));
		list.remove(list.size() - 1);
	
		bubbleUp();
		bubbleDown();
	}
	
	private void bubbleUp()
	{
		int curIndex = list.size() - 1;
		int parentIndex = curIndex / 2;
		String cur = list.get(curIndex);
		
		while((curIndex > 1) && (((Comparable) cur).compareTo(list.get(parentIndex)) < 0 ))
		{
			String parent = list.get(parentIndex);
			list.set(parentIndex, cur);
			list.set(curIndex, parent);
			
			curIndex = parentIndex;
			parentIndex = curIndex / 2;
		}
		
	}
	
	public void bubbleDown()
	{
		int curIndex = 1;
		int childIndex = curIndex * 2;
		String cur = list.get(curIndex);
		
		while((curIndex < list.size() - (2*1+1)) && (((Comparable) cur).compareTo(list.get(childIndex)) > 0 ))
		{
			String parent = list.get(childIndex);
			list.set(childIndex, cur);
			list.set(curIndex, parent);
			
			curIndex = childIndex;
			childIndex = curIndex * 2;
		}
	}
	
	public boolean inOrder()
	{
		for(int i = 1; 2*i+1 < list.size(); i++)
		{
			if(((Comparable) list.get(i)).compareTo((Comparable) list.get(2*i)) > 0 ||
					((Comparable) list.get(i)).compareTo((Comparable) list.get(2*i+1)) > 0)
				return false;
		}
		return true;
	}
	
}
