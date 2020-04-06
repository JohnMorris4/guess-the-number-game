package com.morrisje;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;



public class NumberGeneratorImpl implements NumberGenerator {
//    ==== Fields ====
    private final Random random = new Random();

    @Autowired
    @MaxNumber
    private int maxNumber;

    @Autowired
    @MinNumber
    private int minNumber;

//    === Methods ===
    @Override
    public int next() {

        return random.nextInt(maxNumber - minNumber) + minNumber;
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }


}
