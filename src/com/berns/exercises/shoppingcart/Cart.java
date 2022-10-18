package com.berns.exercises.shoppingcart;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Cart
{
	private Map<Product, Integer> orders;
	private BigDecimal orderTotal = BigDecimal.valueOf(0.0);
	//private Map<Product, Offer> promos;

	public Cart()
	{
		this.orders = new HashMap<>();
	}

	void addItem(Product prod, Integer quantity)
	{
		if (orders.putIfAbsent(prod, quantity) != null)
		{
			orders.computeIfPresent(prod, (k, v) -> v + quantity);
		}
	}

	public BigDecimal getOrderTotal()
	{
		return orderTotal;
	}

	Map<Product, Integer> getOrders()
	{
		return new HashMap<>(orders);
	}

	static Cart instance()
	{
		return new Cart();
	}

	public static void main(String[] args)
	{
	}

	void computeTotalPrice()
	{
		for (Map.Entry<Product, Integer> entry : orders.entrySet())
		{
			BigDecimal orderPrice = entry.getKey().getCost();
			long orderQty = entry.getValue().longValue();
			orderTotal = orderTotal.add(orderPrice.multiply(BigDecimal.valueOf(orderQty)));
		}
	}

	void computeOfferTotalPrice()
	{
		// TODO Auto-generated method stub
	}
}
