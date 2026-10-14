package com.github.anartemieva.numbers.states;

import com.github.anartemieva.numbers.output.OutputFormat;

import static com.github.anartemieva.numbers.common.ValueContainer.Value;

public class RangeState implements State {
    private final Range range;

    public RangeState(Range range) {
        this.range = range;
    }

    @Override
    public State getNextState(Value value) {
        return new PropertySearchState(range, value.get());
    }

    @Override
    public void processData(OutputFormat numberOutput) {
        range.getLimitedStream(range.createStream()).forEach(numberOutput);
    }
}
