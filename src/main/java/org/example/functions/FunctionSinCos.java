package org.example.functions;

import java.math.BigDecimal;

public class FunctionSinCos extends Function {
    @Override
    public BigDecimal compute(BigDecimal x) {
        return BigDecimal.valueOf(Math.sin(x.doubleValue()) * Math.cos(x.doubleValue()) * 0.5);
    }

    @Override
    public String toString() {
        return "sin(x)*cos(x)*0.5";
    }
}
