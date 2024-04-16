package org.example.functions;

import java.math.BigDecimal;

public class FunctionCos extends Function {
    @Override
    public BigDecimal compute(BigDecimal x) {
        return BigDecimal.valueOf(Math.cos(x.doubleValue()) + 1);
    }

    @Override
    public String toString() {
        return "cos(x) + 1";
    }
}
