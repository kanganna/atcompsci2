package heaps;

public class HeapRunner {

	public static void main(String[] args) {

		Heap h = new Heap();
		h.add(new Integer(8));
		h.add(new Integer(12));
		h.add(new Integer(36));
		h.add(new Integer(14));
		h.add(new Integer(23));
		h.add(new Integer(42));
		System.out.println(h);
		
		System.out.println("Adding 18");
		h.add(new Integer(18));
		System.out.println(h);

		System.out.println("Removing the first element");
		h.removeFirst();
		System.out.println(h);
		
		System.out.println("Adding 5");
		h.add(new Integer(5));
		System.out.println(h);
		
	}

}
//add 18
//list
//delete 8
//list
//add 5
//list
