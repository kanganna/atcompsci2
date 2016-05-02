package p9_5;

public class Runner {

	public static void main(String[] args) {

		Line x = new Line();
		
		for(int i = 0; i < 50; i++)
		{
			if(Math.random()*10+1 >= 5)
			{
				System.out.println(x.arrive());
				if(Math.random()*10+1 >= 5)
					System.out.println(x.finished());
			}
		}

	}

}
