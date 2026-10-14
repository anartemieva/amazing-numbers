package com.github.anartemieva.numbers.states;

import com.github.anartemieva.numbers.exceptions.NoUserInputException;
import com.github.anartemieva.numbers.output.OutputFormat;

import static com.github.anartemieva.numbers.common.ValueContainer.Value;

public class InitialState implements State {
    @Override
    public State getNextState(Value value) {
        return new SingleState(value.get());
    }

    @Override
    public void processData(OutputFormat outputFormat) {
        throw new NoUserInputException();
    }
}
