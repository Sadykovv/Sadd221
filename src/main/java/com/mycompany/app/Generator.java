package com.mycompany.app;

import java.util.Random;

public class Generator {
    private Random r;

    public Generator() {
        r = new Random();
    }

    public int Next() {
        return r.nextInt(700-100)+100;
    }
}
