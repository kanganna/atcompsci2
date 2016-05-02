package pascal_triangle;

public class Triangle 
{
	
	public static int[][] pascal(int num) 
	{
		int[][] arr = new int[num][num];
		return pascal(num, arr);
	}

	public static int[][] pascal(int num, int[][] arr)// 3
	{

		if (num == 1) 
		{
			arr[0][0] = 1;
		}

		else 
		{
			pascal(num - 1, arr);
			arr[num - 1][0] = 1;
			arr[num - 1][num - 1] = 1;
			for (int i = num - 2; i > 0; i--) 
			{
				arr[num - 1][i] = arr[num - 2][i] + arr[num - 2][i - 1];
			}
		}

		return arr;
	}
	
}