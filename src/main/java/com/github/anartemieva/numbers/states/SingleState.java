package com.github.anartemieva.numbers.states;

import com.github.anartemieva.numbers.output.OutputFormat;

import static com.github.anartemieva.numbers.common.ValueContainer.Value;

public class SingleState implements State {
    private final long number;

    public SingleState(long number) {
        this.number = number;
    }

    @Override
    public State getNextState(Value value) {
        return new RangeState(new Range(number, value.get()));
    }

    @Override
    public void processData(OutputFormat outputFormat) {
        outputFormat.accept(number);
    }
}
