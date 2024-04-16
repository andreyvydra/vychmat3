package org.example.functions;

import java.math.BigDecimal;

public abstract class Function {
    public abstract BigDecimal compute(BigDecimal x);

    @Override
    public abstract String toString();
}
