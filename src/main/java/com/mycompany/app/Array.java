package com.mycompany.app;



public class Array {
	Generator gen = new Generator();
	public static int w;
	
	public void arr( ) {
		int[] q = new int[10];
		for (int i = 0; i < 10; i++) {
			q[i] = gen.Next();
			w = q[i];
		}
	}

}
