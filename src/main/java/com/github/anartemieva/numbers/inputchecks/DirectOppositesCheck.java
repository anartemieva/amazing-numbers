package com.github.anartemieva.numbers.inputchecks;

import com.github.anartemieva.numbers.exceptions.MutuallyExclusivePropertiesException;
import com.github.anartemieva.numbers.properties.InputPropertySet;
import com.github.anartemieva.numbers.properties.Property;
import com.github.anartemieva.numbers.states.RangeState;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.github.anartemieva.numbers.common.ValueContainer.Value;

public class DirectOppositesCheck extends StateInputCheck {
    public DirectOppositesCheck() {
        super(Set.of(RangeState.class));
    }

    @Override
    public void check(Value value) {
        final var inputProperties = value.<InputPropertySet>get();
        final var opposites = Stream.of(Property.ALL)
                .filter(p -> inputProperties.hasOpposites(p.toString()))
                .map(p -> String.format("[%1$s, -%1$s]", p))
                .collect(Collectors.toList());
        if (!opposites.isEmpty()) {
            throw new MutuallyExclusivePropertiesException(opposites);
        }
    }
}
