package p9_1;

public class CDList {
	
	private ListNode list;
	
	public CDList()
	{
		list = null;
	}
	
	public ListNode getFirst()
	{
		return list;
	}
	
	public void addFirst(CD cd)
	{
		ListNode node = new ListNode(cd, null);
		node.setNext(list);
		list = node;
	}
	
	public void add(CD cd, int pos)
	{
		ListNode node = new ListNode(cd, null);
		ListNode current = list;
		if(pos <= 0)
			addFirst(cd);
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
	
	public void add(CD cd)
	{
		ListNode node = new ListNode(cd, null);
		ListNode current;
		
		if(list == null)
			addFirst(cd);
		else
		{
			current = list;
			while(current.getNext() != null)
				current = current.getNext();
			current.setNext(node);
		}
	}
	
	public void addLast(CD cd)
	{
		add(cd);
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
