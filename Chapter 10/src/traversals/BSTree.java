package traversals;

public class BSTree 
{
	private BSTNode root;
	
	public BSTree()
	{
		root = null;
	}
	
	public void add(Comparable obj)
	{
		BSTNode newNode = new BSTNode(obj);
		
		if(root == null)
			root = newNode;
		else
			addNode(root, newNode);
	}
	
	private void addNode(BSTNode current, BSTNode newNode)
	{
	
		if(((Comparable) newNode.getValue()).compareTo(current.getValue()) < 0)
		{
			if(current.getLeft() == null)
				current.setLeft(newNode);
			else
				addNode((BSTNode)current.getLeft(), newNode);
		}
		else
			if(current.getRight() == null)
				current.setRight(newNode);
			else
				addNode((BSTNode)current.getRight(), newNode);
	}
	
	public String toString()
	{
		return preOrder(root);
	}
	
	private String inOrder(TreeNode current)
	{
		String s = "";
		
		if(current.getLeft() != null)
			s += inOrder(current.getLeft()) + "\n";
		
		s += current.getValue();
		
		if(current.getRight() != null)
			s += "\n" + inOrder(current.getRight());
		
		return s;
	}
	
	private String preOrder(TreeNode current)
	{
		String s = "";
		
		s += current.getValue();
		
		if(current.getLeft() != null)
			s += "\n" + preOrder(current.getLeft());
		
		if(current.getRight() != null)
			s += "\n" + preOrder(current.getRight());
		
		return s;
	}
	
	private String postOrder(TreeNode current)
	{
		String s = "";
		
		
		
		if(current.getLeft() != null)
			s += postOrder(current.getLeft()) + "\n";
		
		if(current.getRight() != null)
			s += postOrder(current.getRight()) + "\n";
		
		s += current.getValue();
		
		return s;
	
	}
	
	public void deleteRoot()
	{
		TreeNode current = root;
		deleteRoot(current);
	}
	
	public void deleteRoot(TreeNode current)
	{	
		if(current.getLeft() == null && current.getRight() == null)
		{
			current = null;
		}
		else 
		{
			if(current.getLeft() != null && current.getRight() != null)
			{ //works
				TreeNode s = current.getRight();
				while(s.getLeft().getLeft() != null)
				{
					s = s.getLeft();
				}
				current.setValue(s.getLeft().getValue());
				s.setLeft(null);
			}
			else if(current.getLeft() != null)
			{
				current.setValue(current.getLeft().getValue());
				current.setLeft(null);
				
			}
			else if(current.getRight() != null)
			{
				current.setValue(current.getRight().getValue());
				current.setRight(null);
			}
		
		
		}
		
	}

}
