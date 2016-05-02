package p10_3;

public class HeapRunner {

	public static void main(String[] args) {

		Heap h = new Heap();
		h.add(new String("Anna Carandang"));
		h.add(new String("Child Carandang"));
		h.add(new String("Carol Liu"));
		h.add(new String("Renato Carandang"));
		h.add(new String("Grandmother Liu"));
		h.add(new String("Grandfather Liu"));
		h.add(new String("Grandfather Carandang"));
		h.add(new String("Grandmother Carandang"));
		System.out.println(h);
		
	}
}
