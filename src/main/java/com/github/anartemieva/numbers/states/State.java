package com.github.anartemieva.numbers.states;
import com.github.anartemieva.numbers.output.OutputFormat;

import static com.github.anartemieva.numbers.common.ValueContainer.Value;

public interface State {
    State getNextState(Value value);
    void processData(OutputFormat numberOutput);
}
