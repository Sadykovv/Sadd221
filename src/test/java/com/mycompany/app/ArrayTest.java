package com.mycompany.app;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


public class ArrayTest {
	private static int e;


	@BeforeClass
	public static void TestGen() {
	Generator var = new Generator();
		 e = (var.Next());
	}



	@Test
	public void test() {
		int[] a = new int[10];
		for (int i = 0; i < 10; i++) {
			TestGen();
			a[i] = e;
			System.out.println(e);
		}
		assertTrue(a.length == 10);
		assertFalse(a==null);

	}

}

