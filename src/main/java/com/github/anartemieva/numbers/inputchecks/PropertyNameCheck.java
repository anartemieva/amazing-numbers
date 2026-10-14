package com.github.anartemieva.numbers.inputchecks;

import com.github.anartemieva.numbers.exceptions.WrongPropertyNameException;
import com.github.anartemieva.numbers.properties.InputPropertySet;
import com.github.anartemieva.numbers.properties.Property;
import com.github.anartemieva.numbers.states.RangeState;

import java.util.Set;
import java.util.stream.Collectors;

import static com.github.anartemieva.numbers.common.ValueContainer.Value;

public class PropertyNameCheck extends StateInputCheck {
    public PropertyNameCheck() {
        super(Set.of(RangeState.class));
    }

    @Override
    public void check(Value value) {
        final var inputProperties = value.<InputPropertySet>get();
        final var wrongNames = inputProperties
                .allPropertyNamesStream()
                .filter(n -> !Property.exists(n))
                .collect(Collectors.toSet());
        if (!wrongNames.isEmpty()) {
            throw new WrongPropertyNameException(wrongNames);
        }
    }
}
