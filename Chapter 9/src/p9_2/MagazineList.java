package p9_2;

public class MagazineList {
	
	/* It is possible to make "subclasses"—a ListNode object that is a component of MagazineList, like so:
	
	private class ListNode {
		public Object value;
		public ListNode next;
		// Since ListNode is private to MagazineList, making the properties private doesn't add any security
		// So you can set valies like node.value = newValue;
		// If you prefer the traditional setter/getter method technique, you can keep it that way.
		// This is just a way that is possible
		
		public ListNode (Object value, ListNode next) {
			this.value = value;
			this.next = next;
		}
	}
	*/
	
	private ListNode header; // Technically the first node of a linked list is called the list's "header"
	private int length; // You should keep track of this value
	
	public MagazineList()
	{
		header = null;
	}
	
	public Magazine get(int pos)
	{
		ListNode current = header;
		for(int i = 0; i < pos; i++)
			current = current.getNext();
		return (Magazine) current.getValue();
	}

	public Magazine getFirst() // Typically the end user doesn't deal with nodes, but with the object being put into the list, in this case Magazines
	{
		return get(0);
	}
	
	public void addFirst(Magazine mag)
	{
		add(mag, 0); // It is better for addFirst(Magazine) to be defined in terms of add(Magazine, int)
	}
	
	public void add(Magazine mag, int pos)
	{
		/*
		This method should traverse to the node at the given position (let's call it "this node"), then 
		set the "next" of the node previous to this node to a new node containing the given magazine, then 
		set the "next" of the new node to the given node.
		
		There are two special cases: inserting an object at the beginning (with no previous node) and at 
		the end (where there is no next node).
		*/
		ListNode node = new ListNode(mag, null);
		ListNode current = header;
		if(pos == 0)
		{
			node.setNext(current);
			header = node;
		
		}
		else if(pos == 1)
		{
			if(((Magazine) current.getValue()).compareTo(mag) > 0)
			{
				node.setNext(current);
				header = node;
			}
			else
				current.setNext(node);
		}
		else if(pos == length )
		{
			current = header;
			while(current.getNext().getNext() != null)
				current = current.getNext();
			if(((Magazine) current.getValue()).compareTo(mag) > 0)
			{
				node.setNext(current.getNext());
				current.setNext(node);
			}
			else
			{
				current = current.getNext();
				current.setNext(node);
			}
		}
		else
		{
			for(int i = 0; i < pos-1; i++)
			{
				current = current.getNext();
			}
		
			node.setNext(current.getNext());
			current.setNext(node);
		}
		
		length++;
	}
	
	public void add(Magazine mag)
	{
		add(mag, length); // It is better for add(Magazine) to be defined in terms of add(Magazine, int)
	}
	
	public void addLast(Magazine mag)
	{
		add(mag);
	}
	
	public void removeFirst()
	{
		remove(0); // Define in terms of remove(int)
	}
	
	public void removeLast()
	{
		remove(length - 1); // Ditto above
	}
	
	public void remove(int pos)
	{
		/*
		This method should traverse to the node at the given position (we'll call it "this node"), 
		then set the "next" of the node previous to this node to this node's "next".
		
		Of course, there are special cases for the first and last node (the first node does not have 
		a node previous to it, and the last node does not have a "next" node.
		*/
		ListNode current = header;
		
		if(pos == 0)
			header.setNext(header.getNext());
		if(pos == length)
		{
			for(int i = 0; i < pos-1; i++)
			{
				current = current.getNext();
			}
			
			current.setNext(null);
		}
		
		for(int i = 0; i < pos-1; i++)
		{
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		length--;
	}
	
	public String toString()
	{
		String result = "";
		ListNode current = header;
		while(current != null)
		{
			result += current.getValue().toString() + "\n";
			current = current.getNext();
		}
		
		return result;
	}
	
	// You should implement the length of the list
	public int length()
	{
		return length;
	}
	
}
