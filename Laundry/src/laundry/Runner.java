package laundry;
import java.util.PriorityQueue;
import java.util.Queue;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> x = new PriorityQueue<Integer>();
		x.add(new Integer(3));
		x.add(new Integer(4));
		x.add(new Integer(7));
		for(Integer z : x)
			System.out.println(z);
	}

}
