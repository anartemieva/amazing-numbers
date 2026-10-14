package com.github.anartemieva.numbers.inputchecks;

import com.github.anartemieva.numbers.exceptions.MutuallyExclusivePropertiesException;
import com.github.anartemieva.numbers.properties.InputPropertySet;
import com.github.anartemieva.numbers.properties.MutuallyExclusiveLocation;
import com.github.anartemieva.numbers.properties.MutuallyExclusivePair;
import com.github.anartemieva.numbers.properties.Property;
import com.github.anartemieva.numbers.states.RangeState;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.github.anartemieva.numbers.common.ValueContainer.Value;

public class MutuallyExclusivePropertiesCheck extends StateInputCheck {
    private static final List<MutuallyExclusivePair> propertyPairs = List.of(
            MutuallyExclusivePair.of(Property.EVEN, Property.ODD, true),
            MutuallyExclusivePair.of(Property.DUCK, Property.SPY, false),
            MutuallyExclusivePair.of(Property.SUNNY, Property.SQUARE, false),
            MutuallyExclusivePair.of(Property.HAPPY, Property.SAD, true)
    );

    public MutuallyExclusivePropertiesCheck() {
        super(Set.of(RangeState.class));
    }

    @Override
    public void check(Value value) {
        final var inputProperties = value.<InputPropertySet>get();
        final var foundProperties = propertyPairs
                .stream()
                .flatMap(inputProperties::getMutuallyExclusionStream)
                .map(MutuallyExclusiveLocation::toString)
                .collect(Collectors.toList());
        if (!foundProperties.isEmpty()) {
            throw new MutuallyExclusivePropertiesException(foundProperties);
        }
    }
}
