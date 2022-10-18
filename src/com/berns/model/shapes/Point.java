package com.berns.model.shapes;

public class Point
{
	private int x;
	private int y;

	public Point(int x, int y)
	{
		super();
		this.x = x;
		this.y = y;
	}

	public int x()
	{
		return x;
	}

	public int y()
	{
		return y;
	}

	@Override
	public String toString()
	{
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	

}
