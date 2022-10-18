package com.berns.model;

import java.io.Serializable;

public class Bar extends Egg implements Serializable
{
	String name;
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (hard ? 1231 : 1237);
		result = prime * result + length;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bar other = (Bar) obj;
		if (hard != other.hard)
			return false;
		if (length != other.length)
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	private boolean hard; 
	private int length;
	

	public boolean isHard()
	{
		return hard;
	}

	public void setHard(boolean hard)
	{
		this.hard = hard;
	}

	public int getLength()
	{
		return length;
	}

	public void setLength(int length)
	{
		this.length = length;
	}

	public Bar(String name)
	{
		this.name = name;
		System.out.println("Name " + name);
		
	}

	@Override
	public String toString()
	{
		return "Bar [name=" + name + "]";
	}
}