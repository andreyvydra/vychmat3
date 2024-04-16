package org.example.functions;

import java.math.BigDecimal;

public class FunctionVar extends Function {
    @Override
    public BigDecimal compute(BigDecimal x) {
        return BigDecimal.ZERO.subtract(x.pow(3)).subtract(x.pow(2)).add(x).add(BigDecimal.valueOf(3));
    }

    @Override
    public String toString() {
        return "-x^3 - x^2 + x + 3";
    }
}
