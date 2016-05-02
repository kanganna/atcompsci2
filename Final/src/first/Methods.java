package first;

import linkedlists.ListNode;
import linkedlists.LinkedList;
import project.BSTNode;
import project.BSTree;

public class Methods {
	
	public static int depth(BSTree x)
	{
		return depth(x.getRoot());
	}
	
	private static int depth(BSTNode t)
	{
		if(t == null)
			return 0;
		
		int left = depth((BSTNode) t.getLeft());
		int right = depth((BSTNode) t.getRight());
		
		if(left > right)
			return left + 1;
		else
			return right + 1;
	}
	
	public static BSTNode binaryTreeSearch(BSTree x, Object key)
	{
		return binaryTreeSearch(x.getRoot(), key);
	}
	
	private static BSTNode binaryTreeSearch(BSTNode current, Object key)
	{
		if(key == null || current == null)
			return null;
		if(key.equals(current.getValue()))
			return current;
		if(((Comparable) key).compareTo(current.getValue()) < 0)
		{
			return binaryTreeSearch((BSTNode)current.getLeft(), key);
		}
		else
			return binaryTreeSearch((BSTNode)current.getRight(), key);
	}
	
	public static String printListBackwards(LinkedList x)
	{
		return printListBackwards(x.getFirst());
	}
	
	private static String printListBackwards(ListNode z)
	{
		if(z == null)
			return "";
		
		return printListBackwards(z.getNext()) + " " + z.getValue();
		
		
	}
	
}
