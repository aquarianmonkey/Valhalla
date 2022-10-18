package com.berns.clients;

import com.berns.model.Foo;
import com.berns.model.Person;

public class TestProtected extends Person
{
	
	public TestProtected()
	{
		super();
		
		this.aProtectedMethod(); // protected method visible through inheritance
	}

	public static void main(String[] args)
	{

		//The superclass's protected method accessible only through inheritance
		//i.e. Direct invocation of method on reference is disallowed
		// e.g. new Person().aProtectedMethod(); // error since in diff pkg
		//e.g. new Foo().aProtectedMethod(); // compiler error since Foo in diff pkg
		
		new TestProtected().aProtectedMethod();  //works only because done within same class.
	}

}
