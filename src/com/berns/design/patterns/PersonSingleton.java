package com.berns.design.patterns;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

class Aa<T> {
	
}
public class PersonSingleton {

	private static PersonSingleton INSTANCE ;
	private PersonSingleton(){
		
		Aa<?> a = new Aa<String>();
	}
			
	public static PersonSingleton getInstance(){
		
		if(INSTANCE == null)
		{
			synchronized(PersonSingleton.class)
			{
				if(INSTANCE == null){
					INSTANCE = new PersonSingleton();
				}
			}
		}
		return INSTANCE;
		
	}
	

	public static void main(String[] args) throws CloneNotSupportedException {

		//System.out.println(PersonSingleton.getInstance());
		PersonSingleton singleton = PersonSingleton.getInstance();
		System.out.println(PersonSingleton.getInstance());
		
		
		PersonSingleton ps = (PersonSingleton) singleton.clone();
		
		PersonSingleton singleton2 = null;
		
		Constructor<?>[] constructors = PersonSingleton.class.getDeclaredConstructors();
		
		for(Constructor con : constructors)
		{
			con.setAccessible(true);
			try {
				singleton2 =  (PersonSingleton) con.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("sg2 > " + singleton2);
		
		
		
	}

}
