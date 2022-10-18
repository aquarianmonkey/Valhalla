package com.berns.model;

import com.berns.clients.TestProtected;

public class Person extends Foo
{
	private String name;
	private int age;

	public Person()
	{
		
	}

	public Person(String name, int age)
	{
		super.name = "fweh";
		this.name = name;
		this.age = age;
	}

	public static void main(String args[]){
		
		// since Foo is in the same package
		new Foo().aProtectedMethod();
		
	}
	
	
	@Override
	public String toString()
	{
		return name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
}
