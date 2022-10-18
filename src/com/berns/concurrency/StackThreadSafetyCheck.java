package com.berns.concurrency;

import com.berns.model.Bar;
import com.berns.model.Egg;

class Labor implements Runnable {

	private Egg food;
	
	Labor(Egg e){
		food = e;
	}
	
	@Override
	public void run()
	{
		System.out.println(">>>Name"+ food.name);
	}
	
	
}


public class StackThreadSafetyCheck  implements Comparable<StackThreadSafetyCheck>
{

	private int price = 0;
	
	private void aa(){}
	
	
	public static void main(String[] args)
	{
		Egg egg = new Egg("s");
	
		Bar bob = new Bar("cloud9");
		
		System.err.println("heheheh");
		
	    
//		Egg scrambled = new Egg("McDo");
//		Thread t1 = new Thread(new Labor(scrambled));
//		Thread t2 = new Thread(new Labor(scrambled));
//		Thread t3 = new Thread(()-> System.out.println(">>>size " + scrambled.size));
//		
//		t1.start();
//		t2.start();
//		t3.start();
//		
		
	}

	
	void count(int[] cars){
		
		cars[0] = 10;
	}
	
	
	@Override
	public int compareTo(StackThreadSafetyCheck o)
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
