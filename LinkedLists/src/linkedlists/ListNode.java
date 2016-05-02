package linkedlists;

public class ListNode 
{
	private Object value;
	private ListNode next;
	
	public ListNode(Object initValue, ListNode initNext)
	{
		value = initValue;
		next = initNext;
	}

	public Object getValue() {
		return value;
	}
	
	public ListNode getNext() {
		return next;
	}
	
	public void setValue(Object newValue) {
		this.value = newValue;
	}

	public void setNext(ListNode newNext) {
		this.next = newNext;
	}
	
	
}
