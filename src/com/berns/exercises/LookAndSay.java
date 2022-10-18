package com.berns.exercises;

public class LookAndSay
{

	static String lookAndSay(String start, int iter)
	{
		if (iter == 0)
			return start;

		int cnt = 0;
		int i = 0;
		char base = start.charAt(0);
		StringBuilder sb = new StringBuilder();

		while (i < start.length())
		{
			if (base == start.charAt(i))
			{
				++i;
				++cnt;
//				if (i == start.length())
//				{
//					sb.append(String.valueOf(cnt)).append(base);
//				}
			}
			else
			{
				// if (cnt > 0)
				// {
				sb.append(String.valueOf(cnt)).append(base);
				cnt = 0;
				// }
				base = start.charAt(i);
			}
		}
		sb.append(String.valueOf(cnt)).append(base);

		return lookAndSay(sb.toString(), --iter);

		// return sb.toString();
	}

	public static void main(String[] args)
	{

		// String start = "1211";
		// String start = "121311"; // 1112111321
		// String start = "11"; // n= 2, 1211

		// System.out.println("Result = " + lookAndSay(start, 4));
		//assert "13112221".equals(lookAndSay(start, 4)) : "look and say was wrong!";
		// assert"213112221".equals(lookAndSay(start, 4)) : "look and say was
		// wrong!";
		
		System.out.println("Yey!!!");

	}

}
