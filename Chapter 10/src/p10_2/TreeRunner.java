package p10_2;

public class TreeRunner {

	public static void main(String[] args) {
		//it work
		BSTree tree = new BSTree();
		
		tree.add(new String("a"));
		tree.add(new String("C"));
		tree.add(new String("c"));
		tree.add(new String("B"));
		tree.add(new String("E"));
		tree.add(new String("f"));
		//a
		//C       c
		//B E    f
		System.out.println(tree);
	}

}
