package com.github.anartemieva.numbers.properties;

public class ParityCheck {
    public static boolean isOdd(long number) {
        return (number & 1) == 1;
    }
}