package com.berns.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Egg implements Cloneable, Serializable
{

	public String name;
	public Size size = Size.SMALL;
	private BigDecimal price = BigDecimal.valueOf(5.35);
	
	public BigDecimal getPrice()
	{
		return price;
	}

	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}

	public Foo foo;

	public enum Size
	{
		SMALL(1), MEDIUM(2), LARGE(3), XLARGE(4);

		Size(int rank)
		{

			this.rank = rank;
		}

		private int rank;

		public int getRank()
		{
			return rank;
		}
	}

	public Egg()
	{
		System.out.println("This is Egg");
	}

	public Egg(String name)
	{
		this.name = name;
	}

	public Egg(String name, BigDecimal price)
	{
		this.name = name;
		this.price = price;
	}

	public Egg(String name, Foo foo)
	{
		this.name = name;
		this.foo = foo;
	}

	protected String req_name()
	{

		return "";
	}

	@Override
	public Object clone()
	{

		try
		{
			return super.clone();
		} catch (CloneNotSupportedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

//	@Override
//	public int hashCode()
//	{
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + ((price == null) ? 0 : price.hashCode());
//		result = prime * result + ((size == null) ? 0 : size.hashCode());
//
//		return result;
//	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Egg))
			return false;
		Egg other = (Egg) obj;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null)
		{
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (size != other.size)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		//String res = new String("Egg [name=" + name + ", size=" + size + ", price=" + price + "]").intern();
		return "Egg [name=" + name + ", size=" + size + ", price=" + price + "]";
	}

	public Foo getFoo()
	{
		return foo;
	}

	public void setFoo(Foo foo)
	{
		this.foo = foo;
	}

	public int getSize()
	{
		return size.getRank();
	}

	public void setSize(Size size)
	{
		this.size = size;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
