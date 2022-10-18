package com.berns.model;

import java.util.ArrayList;
import java.util.List;

import com.berns.clients.Slate2;

public class Foo 
{
	public String name;
	public List<Bar> bars = new ArrayList<>();
	public static List<Foo> foos = new ArrayList<>();

	public Foo(){
	}
	
	public static void main(String[] args)
	{
		
	}
	
	
	public Foo(String name)
	{
		this.name = name;
	}

	@Override
	public void finalize(){
		System.out.println("in finalize");
		foos.add(this);
	}
	
	@Override
	public String toString()
	{
		return "Foo [name=" + name + "]";
	}

	protected void aProtectedMethod(){
		
	}
	
//	@Override
//	public int hashCode(){
//		return 37;
//	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}