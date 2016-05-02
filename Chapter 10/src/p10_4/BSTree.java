package p10_4;

import java.util.regex.Pattern;

public class BSTree 
{
	private BSTNode root;
	
	public BSTree()
	{
		root = null;
	}
	
	public void add(String obj)
	{
		BSTNode newNode = new BSTNode(obj);
		
		if(root == null)
			root = newNode;
		else
			addNode(root, newNode);
	}
	
	private boolean isOperator (String x)
	{
		if(x.equals("+") || x.equals("-") || x.equals("/") || x.equals("*"))
			return true;
		return false;
	}
	
	private void addNode(TreeNode current, BSTNode newNode)
	{
	
		//if(((Comparable) newNode.getValue()).compareTo(current.getValue()) < 0)
		//{
		
		if(current != null && isOperator(current.getValue()))
		{
		
		//why no work
			//why doesn't it get right 2nd layer
			//why
			if(current.getLeft() == null)
				current.setLeft(newNode);
			else if(current.getRight() == null)
				current.setRight(newNode);
			else if(isOperator(current.getLeft().getValue()))
			{
				addNode((BSTNode)current.getLeft(), newNode);
			}
			else if(isOperator(current.getRight().getValue()))
				addNode((BSTNode)current.getRight(), newNode);
			
		}
		//}
		/*else
			if(current.getRight() != null && isOperator(current.getValue()))
			addNode((BSTNode)current.getRight(), newNode);*/
		
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
	
	public String evaluate()
	{
		return evaluate(root);
	}
	
	public String evaluate(TreeNode current)
	{
		//RETHINK 
		//base case = if current.value = integer
		//what are we trying to return?
		
		/*String leftOp = "";
		String rightOp = "";
		if(!Pattern.matches((String) current.getValue(), "[+-/*]"))
		{
			return (String) current.getValue();
		}
		else
		{
			if(current.getLeft() != null)
				leftOp = evaluate(current.getLeft());
			
			if(current.getRight() != null)
				rightOp = evaluate(current.getRight());
			
		}*/
		
		/*if(current.getValue().equals("[0-9]"))
		{
			return current.getValue();
		}*/
		//else
		//{
		if(current != null)
		{
			if(current.getValue().equals("+"))
			{
				return String.valueOf(Integer.parseInt(evaluate(current.getLeft())) + 
						Integer.parseInt(evaluate(current.getRight())));
			}
			else if(current.getValue().equals("-"))
			{
				return String.valueOf(Integer.parseInt(evaluate(current.getLeft())) - 
						Integer.parseInt(evaluate(current.getRight())));
			}
			else if(current.getValue().equals("*"))
			{
				return String.valueOf(Integer.parseInt(evaluate(current.getLeft())) * 
						Integer.parseInt(evaluate(current.getRight())));
			}
			else if(current.getValue().equals("/"))
			{
				return String.valueOf(Integer.parseInt(evaluate(current.getLeft())) / 
						Integer.parseInt(evaluate(current.getRight())));
			}
			else
				return current.getValue();
		}
		else
			return 0 + "";
		//}
		
	}

}
