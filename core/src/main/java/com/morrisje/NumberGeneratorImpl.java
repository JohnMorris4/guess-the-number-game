package com.morrisje;

import java.util.Random;



public class NumberGeneratorImpl implements NumberGenerator {
//    ==== Fields ====
    private final Random random = new Random();
    private int maxNumber = 100;

//    === Methods ===
    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}