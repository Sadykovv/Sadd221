package com.mycompany.app;

import org.junit.Test;

import static org.junit.Assert.*;

public class GeneratorTest {

    @Test
    public void next() {
        Generator gnr = new Generator();
        int chislo = gnr.Next();
        assertTrue(chislo>=100 && chislo<=700);
        System.out.println("Сгенерированное число = "+chislo);
    }
}