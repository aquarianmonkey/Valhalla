package com.berns.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class NonblockingCounter
{
	private AtomicInteger value = new AtomicInteger(1);

	public int getValue()
	{
		return value.get();
	}

	public int increment()
	{
		int v;
		do
		{
			v = value.get();
		}
		while (!value.compareAndSet(v, v + 1));
		return v + 1;
	}
}