package linkedlists;

public class LinkedList {
	
	private ListNode list;
	
	public LinkedList()
	{
		list = null;
	}
	
	public ListNode getFirst()
	{
		return list;
	}
	
	public void addFirst(Object obj)
	{
		ListNode node = new ListNode(obj, null);
		node.setNext(list);
		list = node;
	}
	
	public void add(Object obj, int pos)
	{
		ListNode node = new ListNode(obj, null);
		ListNode current = list;
		if(pos <= 0)
			addFirst(obj);
		else
		{
			for(int i = 0; i < pos-1; i++)
			{
				current = current.getNext();
			}
		
			node.setNext(current.getNext());
			current.setNext(node);
		}
	}
	
	public void add(Object obj)
	{
		ListNode node = new ListNode(obj, null);
		ListNode current;
		
		if(list == null)
			addFirst(obj);
		else
		{
			current = list;
			while(current.getNext() != null)
				current = current.getNext();
			current.setNext(node);
		}
	}
	
	public void addLast(Object obj)
	{
		add(obj);
	}
	
	public void removeFirst()
	{
		list = list.getNext();
	}
	
	public void removeLast()
	{
		ListNode current = list;
		while(current.getNext().getNext() != null)
			current = current.getNext();
		current.setNext(null);
	}
	
	public void remove(int pos)
	{
		ListNode current = list;
		for(int i = 0; i < pos-1; i++)
		{
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
	}
	
	public String toString()
	{
		String result = "";
		ListNode current = list;
		while(current != null)
		{
			result += current.getValue().toString() + "\n";
			current = current.getNext();
		}
		
		return result;
	}
	
}
