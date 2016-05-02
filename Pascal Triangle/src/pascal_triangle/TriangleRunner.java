package pascal_triangle;

public class TriangleRunner {

	public static void main(String[] args) {
		//Triangle x = new Triangle();
		int[][] num = Triangle.pascal(15);
		for(int i = 0;  i < num.length; i++)
		{
			if(i % 5 == 0)
			{
				for(int k = i; k < num.length+9; k++)
				{
					System.out.print(" ");
				}
			}
			else
			{
				for(int k = i; k < num.length+10; k++)
				{
					System.out.print(" ");
				}
			}
			
			for(int j = 0; j < i+1; j++)
			{
				System.out.print(num[i][j] + " ");
			}
			System.out.println();
			
		}
		

	}

}
