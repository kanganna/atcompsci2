package project;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class BSTree 
{
	private BSTNode root;
	private ArrayList<Integer> array, oldArray;
	
	public BSTree()
	{
		root = null;
		array = new ArrayList<Integer>();
		oldArray = new ArrayList<Integer>();
	}
	
	
	
	public void add(Integer obj)
	{
		BSTNode newNode = new BSTNode(obj);
		
		if(root == null)
		{
			oldArray.add(obj);
			root = newNode;
		}
		else
		{
			oldArray.add(obj);
			addNode(root, newNode);
		}
	}
	
	private void addNode(BSTNode current, BSTNode newNode)
	{
		
		if(((Comparable) newNode.getValue()).compareTo(current.getValue()) < 0)
		{
			if(current.getLeft() == null)
			{
				
				current.setLeft(newNode);
			}
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
	//FIGURE OUT THE HYPHENS
	private String inOrder(TreeNode current, int level)
	{
		String s = "";
		
		if(current.getLeft() != null)
		{
	
			s += inOrder(current.getLeft(), level++) + "\n";
	
		}
		
		s += current.getValue();
		
		if(current.getRight() != null)
		{

			s += "\n" + inOrder(current.getRight(), level++);
			
		}
		return s;
	}
	
	private String inOrder(TreeNode current)
	{
		return inOrder(root, 0);
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
	
	/*public String search(Integer key)
	{
		toArray(root);
		if(!array.contains(key))
			return "No match.";
		
		else
		{
			String s = "Index of key is: " + array.indexOf(key);
			s += "\nNumber of steps is: " + search(root, key);
			s += "\nMin Value = " + getMin(root);
			s += "\nMax Value = " + getMax(root);
			s += "\nLast key value = " + array.get(array.size()-1);
			s += "# of Levels = " + getHeight(root);
			return s;
			
		}
	}*/
	
	public String search(Integer key)
	{
		String x;
		toArray();
		if(!array.contains(key))
			x = "No match;";
		else
		{
			
			x = "Index of key is: " + oldArray.indexOf(key);
			x += "\nNumber of steps is: " + search(root, key);
			x += "\nMin Value = " + getMin(root);
			x += "\nMax Value = " + getMax(root);
			x += "\nLast key value = "  + oldArray.get(array.size()-1);
			x += "\n# of Levels = " + (getHeight(root) + 1);
			
		}
		
		return x;
	}
	
	public int getMin(TreeNode treeNode)
	{
		if(treeNode.getLeft() == null)
			return (Integer) treeNode.getValue();
		return getMin(treeNode.getLeft());
	}
	
	//MAYBE FIGURE OUT WHY THIS ISNT WORKING
	public int getMax(TreeNode treeNode)
	{
		/*if(treeNode.getRight() == null)
			return (Integer) treeNode.getValue();
		return getMin(treeNode.getRight());*/
		return (Integer) array.get(array.size()-1);
	}
	
	public int getHeight(TreeNode t)
	{
		if(t == null)
			return -1;
		
		int left = getHeight(t.getLeft());
		int right = getHeight(t.getRight());
		
		if(left > right)
			return left + 1;
		else
			return right + 1;
	}
	
	public int search(BSTNode current, Integer key)
	{
		if(key == null)
			return 0;
		if(key.equals(current.getValue()))
			return 0;
		if(((Comparable) key).compareTo(current.getValue()) < 0)
		{
			return 1 + search((BSTNode)current.getLeft(), key);
		}
		else
			return 1 + search((BSTNode)current.getRight(), key);
	}
	
	private void toArray()
	{
		for(String x : preOrder(root).split("\n"))
		{
			array.add(Integer.valueOf(x));
		}
		
	}
	
	public boolean contains(Integer k)
	{
		return array.contains(k);
	}
	
	public void print()
	{
		printHelper(root, "");
	}
	
	private static void printHelper(TreeNode treeNode, String indent)
	{
		if(treeNode == null)
		{
			System.out.println();
			return;
		}
		
		String newIndent;
		if(indent.equals(" "))
			newIndent = "---";
		else
			newIndent = "---" + indent;
		
		printHelper(treeNode.getLeft(), newIndent);
		
		System.out.println(indent + treeNode.getValue());
		
		printHelper(treeNode.getRight(), newIndent);
	}
	
	public BSTNode getRoot()
	{
		return root;
	}
	
}
