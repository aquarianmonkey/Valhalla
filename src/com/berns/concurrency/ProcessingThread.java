package com.berns.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class ProcessingThread implements Runnable
{
	private static final int MAX = 5;
	//private int count;
	private AtomicInteger count = new AtomicInteger(0);

	private void printLn(String text)
	{
		System.out.println(text);
	}
	
	@Override
	public void run()
	{
		printLn("[Thread id: " + Thread.currentThread().getName() + "] - Run");
		for (int i = 1; i < MAX; i++)
		{
			processSomething(i);
			printLn("[Thread id: " + Thread.currentThread().getName() + ";loop: " + i +"] count= " + count.incrementAndGet());
		}
	}

	public int getCount()
	{
//		return this.count;
		return this.count.get();
	}

	private void processSomething(int i)
	{
		// processing some job
		try
		{
			Thread.sleep(i * 1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
