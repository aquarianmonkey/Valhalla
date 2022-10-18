package com.berns.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class CarModel
{

	/* Required car parts: 1 Engine, 4 wheels, and 2 doors */
	public Engine engine = new Engine();
	public Wheel[] wheel = new Wheel[4];
	public Door left = new Door(), right = new Door();

	public CarModel()
	{
		for (int i = 0; i < 4; i++)
			wheel[i] = new Wheel();
	}

	/* Launcher */
	public static void main(String[] args) throws IOException, InterruptedException
	{
		final String LINE_SEPARATOR = System.getProperty("line.separator");
		final int BORDER_CHAR_LENGTH = 40;
		final int UNREF_OBJ_CREATED = 10;
		StringBuffer menu = new StringBuffer();
		CarModel car = new CarModel();

		ReferenceQueue<Object> rq = new ReferenceQueue<>();
		Object cat = new Object();
		WeakReference<Object> wr = new WeakReference<>(cat, rq);
		
		
		/* Create the menu */
		for (int i = 0; i < BORDER_CHAR_LENGTH; i++)
			menu.append('-');
		menu.append(LINE_SEPARATOR).append("   (1) Simulate car usage");
		menu.append(LINE_SEPARATOR).append("   (2) Create unreferenced objects");
		menu.append(LINE_SEPARATOR).append("   (3) Create weak map");
		menu.append(LINE_SEPARATOR).append("   (4) Nullify key");
		menu.append(LINE_SEPARATOR).append("   (q) Quit");
		menu.append(LINE_SEPARATOR);
		for (int i = 0; i < BORDER_CHAR_LENGTH; i++)
			menu.append('-');

		/* Display the menu */
		System.out.println("CarModel started" + LINE_SEPARATOR + "Menu:");
		System.out.println(menu.toString());
		System.out.println("Choose an option:");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine().trim();

		/* Accept input for the desired option */
		while (!input.equalsIgnoreCase("q"))
		{
			/* Check for invalid entry */
			if (input == null || input.length() != 1 || !Character.isDigit(input.charAt(0)))
			{
				System.err.println("Wrong option");
				input = in.readLine().trim();
				continue;
			}

			switch (Integer.valueOf(input).intValue())
			{
			case 1:
//				simulateCarUsage(car);

				
				break;
			case 2:

//				for (int i = 0; i < UNREF_OBJ_CREATED; i++)
//					new CarModel();
				

				System.out.println(UNREF_OBJ_CREATED + " unreferenced objects of CarModel has been created");
				break;
			case 3:
				cat = null;
				System.gc();
				System.out.println( "1>>> " + wr.get());
				wr.enqueue();
				
				while(true)
				{
					System.out.println( "2a>>> ref enqueued? " + wr.isEnqueued());
					Reference<? extends Object> ref = rq.remove();
					
					if(wr == ref){
						//ref=null;
						System.out.println( "2>>> " + wr.get());
						break;
					}
				}
				System.out.println( "3>>> ");
				break;

			case 4:

				break;
			default:
				System.err.println("Wrong option");
			}
			input = in.readLine().trim();
		}

	}

	/* Simulates car usage */
	public static void simulateCarUsage(CarModel car)
	{
		car.left.window.rollup();
		car.engine.start();
		car.engine.rev();
		car.wheel[0].align();
		car.engine.stop();
	}
}

/* Inner classes used to model car parts */
class Engine
{
	public void start()
	{
		System.out.println("Start the car.");
	}

	public void rev()
	{
		System.out.println("Rev the engine.");
	}

	public void stop()
	{
		System.out.println("Car stopped.");
	}
}

class Wheel
{
	public void align()
	{
		System.out.println("Tires aligned.");
	}
}

class Window
{
	public void rollup()
	{
		System.out.println("Rollup the window.");
	}

	public void rolldown()
	{
		System.out.println("Rolldown the window.");
	}
}

class Door
{
	public Window window = new Window();

	public void open()
	{
		System.out.println("Open()");
	}

	public void close()
	{
		System.out.println("Close()");
	}
}