package magazine;

public class MagazineList {
	
	private ListNode list;
	
	public MagazineList()
	{
		list = null;
	}
	
	public ListNode getFirst()
	{
		return list;
	}
	
	public void addFirst(CD mag)
	{
		ListNode node = new ListNode(mag, null);
		node.setNext(list);
		list = node;
	}
	
	public void add(CD mag, int pos)
	{
		ListNode node = new ListNode(mag, null);
		ListNode current = list;
		if(pos <= 0)
			addFirst(mag);
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
	
	public void add(CD mag)
	{
		ListNode node = new ListNode(mag, null);
		ListNode current;
		
		if(list == null)
			addFirst(mag);
		else
		{
			current = list;
			while(current.getNext() != null)
				current = current.getNext();
			current.setNext(node);
		}
	}
	
	public void addLast(CD mag)
	{
		add(mag);
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
