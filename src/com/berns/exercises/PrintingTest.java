package com.berns.exercises;

public class PrintingTest
{

	public static void main(String[] args)
	{
		int row = 8;
		int len = (4* row - 3) + 1;
		int indnt = 0;
		for (int n = 1, m =0; n < row+1; n++, m+=2)
		{
			for (int i = 1; i < len; i++)
			{
				if (i % 2 == 0)
				{
					System.out.print(" ");
					continue;
				}

//				if (i > indnt && i < (len - indnt))
				if (i > m && i < (len - m))
				{
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			//indnt += 2;
			System.out.println();
		}

	}

}
