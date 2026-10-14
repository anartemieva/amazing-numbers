package com.github.anartemieva.numbers.output;

import com.github.anartemieva.numbers.properties.Property;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShortFormat implements OutputFormat {
    @Override
    public void accept(long number) {
        System.out.printf("\t%d is %s\n", number,
                Stream.of(Property.ALL)
                        .filter(p -> p.check(number))
                        .map(Property::toString)
                        .collect(Collectors.joining(", "))
                        .toLowerCase());
    }
}
