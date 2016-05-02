package p10_4;

public class TreeRunner {

	public static void main(String[] args) {
		
		BSTree tree = new BSTree();
		System.out.print("(8/1) + 1 = ");
		tree.add("+");
		tree.add("/");
		tree.add("1");
		tree.add("8");
		tree.add("1");
		
		System.out.println(tree.evaluate());
	}

}
//     +
//   /   1
// 8  1  

   