package p9_6;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Runner {

	public static void main(String[] args) throws FileNotFoundException {

		Line x = new Line("1");
		Line y = new Line("2");
		Line z = new Line("3");
		Line a = new Line("4");
		
		PrintWriter b = new PrintWriter("C:\\Users\\ann85_000\\Desktop\\runner.txt");
		
		for(int i = 0; i < 50; i++)
		{
			if(Math.random()*10+1 >= 5)
			{
				
				
				System.out.println(new Customer(x,y,z,a).queue().arrive());
				b.println("1: " + x.length() + "\t2: " + y.length() + "\t3: " + z.length() + "\t4: " + a.length());
				
				if(Math.random()*10+1 > 5)
				{
					switch((int)(Math.random()*4 + 1))
					{
					case 1:
						System.out.print(x.finished());
						break;
					case 2:
						System.out.print(y.finished());
						break;
					case 3:
						System.out.print(z.finished());
						break;
					case 4:
						System.out.print(a.finished());
						break;
					}
				}
				
				b.println("1: " + x.length() + "\t2: " + y.length() + "\t3: " + z.length() + "\t4: " + a.length());
			}
		}
		
		b.close();

	}

}
