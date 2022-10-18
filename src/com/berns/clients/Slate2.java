package com.berns.clients;

import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import com.berns.model.Egg;

class Client
{
	private Egg e ;
	private WeakReference<Egg> wre ;
	
	Client(Egg e)
	{
		this.e = e;
		System.out.println("Client is Alive!!");
	}
	
	Client(WeakReference<Egg> we)
	{
		this.wre = we;
		System.out.println("Client is Alive!!");
	}

	void call(){
		System.out.println("Client prop: " + e);
	}
	void callWeakEggRef(){
		System.out.println("Client prop: " + wre.get());
	}
	
}

class Pop
{

	void call() throws Exception{}
}

public class Slate2 extends Pop implements Cloneable, Runnable
{
	private final String name = "Ben";
	private Egg food = new Egg("soft");
	private Object[] elements = {1,2,3};

	private Slate2()
	{
		System.out.println("Slate2 alive!");
	}

	/*
	 * @Override public Slate2 clone(){
	 * 
	 * try { return (Slate2) super.clone(); } catch (CloneNotSupportedException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); throw new
	 * RuntimeException(); }
	 * 
	 * }
	 */

	@Override
	void call() throws NullPointerException
	{
		try
		{
			Slate2 clone = (Slate2) super.clone();
			System.out.println("Clone's elements " + Arrays.toString(clone.elements));
			
			clone.elements[0] = 7;
			System.out.println("Clone's elements " + Arrays.toString(clone.elements));

			clone.elements = new Object[]{1,2,3};
			System.out.println("Orig's elements " + Arrays.toString(this.elements));
			

		} catch (CloneNotSupportedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception
	{

		//testReflectionPrivateConstructor();
		//new Slate2().call();

		Egg e1 = new Egg("A");
		WeakReference<Egg> wr = new WeakReference<>(e1);
		//Client cl = new Client(e1);
		Client cl2 = new Client(wr);
		e1 = null;
		System.gc();
		
		Thread.sleep(1500);
		
		//cl.call();
		cl2.call();
	
		System.out.println(wr.get());
		
	}

	private static void testReflectionPrivateConstructor()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException
	{
		// System.out.println(Arrays.toString(new
		// Slate2().getClass().getMethods()));

		Class<?> slate2Obj = Class.forName("com.berns.clients.Client");
		System.out.println(slate2Obj.getDeclaredConstructors().length);
		Constructor<?> constructor = slate2Obj.getDeclaredConstructors()[0];

		constructor.setAccessible(false);
		Client obj1 = (Client) constructor.newInstance();
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		
	}

}
