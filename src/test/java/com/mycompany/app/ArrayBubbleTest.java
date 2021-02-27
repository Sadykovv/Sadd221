package com.mycompany.app;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayBubbleTest {

    static ArrayBubble array;
    @BeforeClass
    public static void setUp() throws Exception {
        array = new ArrayBubble(5);
        array.into(163);//заполняем массив
        array.into(300);
        array.into(184);
        array.into(191);
        array.into(174);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        array.printer();
    }

    @Test
    public void bubbleSorter() {
        array.bubbleSorter();
        assertArrayEquals(new long[]{163,174,184,191,300},array.getMas());
    }
}