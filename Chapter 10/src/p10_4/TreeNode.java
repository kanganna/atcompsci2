package p10_4;

public class TreeNode 
{
	private String value;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(String initValue, TreeNode initLeft, TreeNode initRight)
	{
		value = initValue;
		left = initLeft;
		right = initRight;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public boolean hasChildren()
	{
		if(left != null && right != null)
			return true;
		return false;
	}
	

}
