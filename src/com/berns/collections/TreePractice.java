package com.berns.collections;

import java.util.Arrays;
import java.util.TreeSet;

public class TreePractice {

	public static void main(String[] args) {

		treeSet();
	}

	static void treeSet(){
		
		TreeSet<Integer> tset = new TreeSet<>();
		
		tset.addAll(Arrays.asList(5,2,6,1,3));
		System.out.println("Tree: " + tset);
		tset.add(4);
		System.out.println("Insert 4: " + tset);
		
		
	}
	
}
