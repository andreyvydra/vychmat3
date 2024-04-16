package org.example.functions;

import java.math.BigDecimal;
import java.rmi.MarshalException;

public class FunctionSin extends Function {
    @Override
    public BigDecimal compute(BigDecimal x) {
        return BigDecimal.valueOf(Math.sin(x.doubleValue()));
    }

    @Override
    public String toString() {
        return "sin(x)";
    }
}
