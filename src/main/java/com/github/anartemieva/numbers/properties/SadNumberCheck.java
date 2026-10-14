package com.github.anartemieva.numbers.properties;

public class SadNumberCheck implements PropertyCheck {
    @Override
    public boolean check(long number) {
        return !HappyCheck.isHappyNumber(number);
    }
}
