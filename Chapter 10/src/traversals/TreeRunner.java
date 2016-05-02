package traversals;

public class TreeRunner {

	public static void main(String[] args) {
		
		BSTree tree = new BSTree();
		tree.add(new Integer(20));
		tree.add(new Integer(8));
		tree.add(new Integer(22));
		tree.add(new Integer(4));
		tree.add(new Integer(12));
		tree.add(new Integer(21));
		System.out.println(tree);
		System.out.println();
		tree.deleteRoot();
		System.out.println(tree);
	}

}
