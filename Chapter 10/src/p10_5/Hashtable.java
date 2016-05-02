package p10_5;

public class Hashtable {
	
	private int size;
	private ListNode[] table;
	
	
	public Hashtable(int numSlots)
	{
		size = numSlots;
		table = new ListNode[size];
	}
	
	public void add(Object obj)
	{
		ListNode element = new ListNode(obj, null);
		
		int index = obj.hashCode() % size;
		
		if(table[index] == obj)
			table[index] = element;
		else
		{
			ListNode current = table[index];
			/*while(current.getNext() != null)
				current = current.getNext();
			current.setNext(element);*/
			element.setNext(current);
			table[index] = element;
		}
	}
	
	public String toString()
	{
		String str = "";
		
		for(int i = 0; i < size; i++)
		{
			str += i+ ": ";
			ListNode current = table[i];
			while(current != null)
			{
				str += current.getValue() + " ";
				current = current.getNext();
			}
			str += "\n";
		}
		
		return str;
	}

}
