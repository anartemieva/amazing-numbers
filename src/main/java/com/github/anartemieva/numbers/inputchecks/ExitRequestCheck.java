package com.github.anartemieva.numbers.inputchecks;

import com.github.anartemieva.numbers.exceptions.ExitRequestException;
import com.github.anartemieva.numbers.states.InitialState;

import java.util.Set;

import static com.github.anartemieva.numbers.common.ValueContainer.Value;

public class ExitRequestCheck extends StateInputCheck {
    public ExitRequestCheck() {
        super(Set.of(InitialState.class));
    }

    @Override
    public void check(Value value) {
        if (value.<Long>get() == 0L) {
            throw new ExitRequestException();
        }
    }
}
