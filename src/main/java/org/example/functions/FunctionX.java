package org.example.functions;

import java.math.BigDecimal;

public class FunctionX extends Function {
    @Override
    public BigDecimal compute(BigDecimal x) {
        return x.add(BigDecimal.TWO);
    }

    @Override
    public String toString() {
        return "x + 2";
    }
}
