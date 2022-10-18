package com.berns.exercises.shoppingcart;

import java.math.BigDecimal;
import java.util.Currency;

public class Product
{

	private ProductTypes type;
	private BigDecimal originalPrice;
	
	@Override
	public String toString()
	{
		return "Product [type=" + type + ", cost=" + originalPrice + "]";
	}


	public Product(ProductTypes type, BigDecimal cost)
	{
		super();
		this.type = type;
		this.originalPrice = cost;
	}


	public ProductTypes getType()
	{
		return type;
	}


	public BigDecimal getCost()
	{
		return originalPrice;
	}


	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((originalPrice == null) ? 0 : originalPrice.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		Product other = (Product) obj;
		if (originalPrice == null)
		{
			if (other.originalPrice != null)
			{
				return false;
			}
		} else if (!originalPrice.equals(other.originalPrice))
		{
			return false;
		}
		if (type != other.type)
		{
			return false;
		}
		return true;
	}
	
}
