package com.berns.model;


abstract class A {
	
	abstract void call();
}
abstract class B extends A{
  static void yell(){
	  System.out.println("B: yell()");
  }	
	
}
class C extends B{

	public C(){
		int x =1;
	}

	static void yell(){
		System.out.println("C: yell()");
	}
	
	@Override
	void call() {
		// TODO Auto-generated method stub
		
	}
	
}

public class MultipleClasses {

	public static void main(String[] args) {

		B broker = new C();
		new C().yell();
		
	}

}
