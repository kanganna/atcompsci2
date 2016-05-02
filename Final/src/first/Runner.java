package first;
import linkedlists.LinkedList;

import project.BSTNode;
import project.BSTree;

public class Runner {

	public static void main(String[] args) {
		
		BSTree tree = new BSTree();
		tree.add(new Integer(49));
		tree.add(new Integer(28));
		tree.add(new Integer(83));
		tree.add(new Integer(18));
		tree.add(new Integer(40));
		tree.add(new Integer(71));
		tree.add(new Integer(97));
		tree.add(new Integer(11));
		tree.add(new Integer(19));
		tree.add(new Integer(32));
		tree.add(new Integer(44));
		tree.add(new Integer(69));
		tree.add(new Integer(72));
		tree.add(new Integer(92));
		tree.add(new Integer(99));
		
		BSTNode x = Methods.binaryTreeSearch(tree, new Integer(188));
		
		System.out.println(Methods.depth(tree));
		System.out.println(x);
		
		LinkedList z = new LinkedList();
		z.add(new Integer(9));
		z.add(new Integer(10));
		z.add(new Integer(11));
		z.add(new Integer(12));
		z.add(new Integer(13));
		z.add(new Integer(14));
		z.add(new Integer(20));
		z.add(new Integer(1));
		z.add(new Integer(99));
		
		System.out.println(Methods.printListBackwards(z));
		
		
		
	}

}
