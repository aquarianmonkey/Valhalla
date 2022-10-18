package com.berns.utils;

public class Print
{

	static public void out(String s, Object... args)
	{
		System.out.printf(s,args);
	}

    static public void out(Object o)
    {
    	System.out.println(">>>" + o);
    }

}
