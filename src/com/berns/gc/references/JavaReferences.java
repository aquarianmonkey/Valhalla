package com.berns.gc.references;

import java.lang.ref.WeakReference;

import com.berns.model.Egg;

public class JavaReferences
{

	public static void main(String[] args)
	{
		testWeakReference();
		
	}

	public static void testWeakReference()
	{
		Egg e1 = new Egg("A");
		WeakReference<Egg> wr = new WeakReference<>(e1);

		//e1 = null; // clear strong reference to Egg.
		System.gc();
		try
		{
			Thread.sleep(500);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println("Referent in weakref : " + wr.get());
	}

}
