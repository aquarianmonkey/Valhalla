package com.berns.exercises.shoppingcart;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

public class CheckOutSystem
{
	private Cart shopCart;
	
	public CheckOutSystem(Cart shoppingCart)
	{
		this.shopCart = shoppingCart;
	}

	void checkOut(boolean promoActive)
	{
		if (promoActive)
			shopCart.computeOfferTotalPrice();
		else
			shopCart.computeTotalPrice();
	}

	public static void main(String[] args)
	{
		Cart shoppingCart = Cart.instance();
		Product bread = new Product(ProductTypes.BREAD, BigDecimal.valueOf(1.0));
		shoppingCart.addItem(bread, 1);
		Product milk = new Product(ProductTypes.MILK, BigDecimal.valueOf(.6));
		shoppingCart.addItem(milk, 1);
		Product banana = new Product(ProductTypes.BANANA, BigDecimal.valueOf(.4));
		shoppingCart.addItem(banana, 1);
		shoppingCart.addItem(banana, 1);
		shoppingCart.getOrders().forEach((k, v) -> System.out.println("Key: " + k + "->" + " Qty:" + v));
		
		CheckOutSystem supermarket = new CheckOutSystem(shoppingCart);
		supermarket.checkOut(false);
		System.out.println("Checkout total: " + shoppingCart.getOrderTotal());
	}
}
