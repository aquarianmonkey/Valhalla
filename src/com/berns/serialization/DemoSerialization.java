package com.berns.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.berns.model.Bar;
import com.berns.model.Egg;

public class DemoSerialization
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	/**
	 *  Constructor of non-serializable objects will be invoked 
	 *  when their derived objects are unmarshalled. 
	 *  Unmarshalled objects will not be re-instantiated,i.e. no constructor calls anymore. 
	 */
	static void demoSerialization()
	{
		Bar scrambled = new Bar("scrammy"); // serializable class
		try (FileOutputStream fos = new FileOutputStream("src/com/berns/clients/data.oop");
				ObjectOutputStream oos = new ObjectOutputStream(fos);)
		{
			oos.writeObject(scrambled);

			FileInputStream fis = new FileInputStream("src/com/berns/clients/data.oop");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Bar unmarshalled = (Bar) ois.readObject(); // parent class constructor invoked if parent non-serializable
			ois.close();

		} catch (IOException | ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
