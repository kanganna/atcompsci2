package magazine;

public class Queue extends MagazineList {
	
	public Queue()
	{
		super();
	}
	
	public void enqueue(CD mag)
	{
		add(mag);
	}
	
	public void dequeue()
	{
		removeFirst();
	}
	
	public Object peek()
	{
		return getFirst().getValue();
	}
	
	public boolean isEmpty()
	{
		if(getFirst() == null)
			return true;
		return false;
	}

}
