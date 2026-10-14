package com.github.anartemieva.numbers.inputchecks;

import com.github.anartemieva.numbers.exceptions.NaturalNumberException;
import com.github.anartemieva.numbers.states.InitialState;
import com.github.anartemieva.numbers.states.SingleState;

import java.util.Set;

import static com.github.anartemieva.numbers.common.ValueContainer.Value;

public class NaturalNumberCheck extends StateInputCheck {
    public NaturalNumberCheck() {
        super(Set.of(InitialState.class, SingleState.class));
    }

    @Override
    public void check(Value value) {
        if (value.<Long>get() < 1L) {
            throw new NaturalNumberException();
        }
    }
}
