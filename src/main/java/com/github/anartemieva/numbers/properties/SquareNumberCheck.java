package com.github.anartemieva.numbers.properties;

public class SquareNumberCheck implements PropertyCheck {
    @Override
    public boolean check(long number) {
        return PerfectSquareCheck.isPerfectSquare(number);
    }
}
