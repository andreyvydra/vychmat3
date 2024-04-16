package org.example;

import org.example.functions.Function;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;

public class MethodStorage {
    private BigDecimal left;
    private BigDecimal right;
    private BigDecimal splits = BigDecimal.valueOf(4);

    private HashMap<Integer, Method> methods = new HashMap<>();

    public MethodStorage() throws NoSuchMethodException {
        methods.put(1, MethodStorage.class.getMethod("rightRectangleMethod", Function.class));
        methods.put(2, MethodStorage.class.getMethod("leftRectangleMethod", Function.class));
        methods.put(3, MethodStorage.class.getMethod("middleRectangleMethod", Function.class));
        methods.put(4, MethodStorage.class.getMethod("trapezoidMethod", Function.class));
        methods.put(5, MethodStorage.class.getMethod("simpsonMethod", Function.class));
    }

    public void setLeft(BigDecimal left) {
        this.left = left;
    }

    public void setRight(BigDecimal right) {
        this.right = right;
    }

    public void setSplits(BigDecimal splits) {
        this.splits = splits;
    }

    public BigDecimal getSplits() {
        return splits;
    }

    public HashMap<Integer, Method> getMethods() {
        return methods;
    }

    public BigDecimal rightRectangleMethod(Function function) {
        BigDecimal res = BigDecimal.ZERO;
        BigDecimal h = right.subtract(left).divide(splits, MathContext.DECIMAL32);
        BigDecimal x = left.add(h);
        for (int i = 1; i <= splits.intValue(); i++) {
            x = x.add(h);
            res = res.add(function.compute(x));
        }
        res = res.multiply(h);
        return res;
    }

    public BigDecimal leftRectangleMethod(Function function) {
        BigDecimal res = BigDecimal.ZERO;
        BigDecimal h = right.subtract(left).divide(splits, MathContext.DECIMAL32);
        BigDecimal x = left;
        for (int i = 1; i <= splits.intValue(); i++) {
            res = res.add(function.compute(x));
            x = x.add(h);
        }
        res = res.multiply(h);
        return res;
    }

    public BigDecimal middleRectangleMethod(Function function) {
        BigDecimal res = BigDecimal.ZERO;
        BigDecimal h = right.subtract(left).divide(splits, MathContext.DECIMAL32);
        BigDecimal hHalf = h.divide(BigDecimal.TWO, MathContext.DECIMAL32);
        BigDecimal x = left.add(hHalf);
        for (int i = 1; i <= splits.intValue(); i++) {
            res = res.add(function.compute(x));
            x = x.add(h);
        }
        res = res.multiply(h);
        return res;
    }


    public BigDecimal trapezoidMethod(Function function) {
        BigDecimal res = function.compute(left).add(function.compute(right));
        BigDecimal h = right.subtract(left).divide(splits, MathContext.DECIMAL32);
        BigDecimal x = left;
        for (int i = 1; i < splits.intValue(); i++) {
            x = x.add(h);
            res = res.add(function.compute(x).multiply(BigDecimal.TWO));
        }
        res = res.multiply(h.divide(BigDecimal.TWO, MathContext.DECIMAL32));
        return res;
    }

    public BigDecimal simpsonMethod(Function function) {
        BigDecimal res = function.compute(left).add(function.compute(right));
        BigDecimal h = right.subtract(left).divide(splits, MathContext.DECIMAL32);
        BigDecimal x = left;
        for (int i = 1; i < splits.intValue(); i++) {
            x = x.add(h);
            if (i % 2 == 0) {
                res = res.add(function.compute(x).multiply(BigDecimal.valueOf(2)));
            } else {
                res = res.add(function.compute(x).multiply(BigDecimal.valueOf(4)));
            }

        }
        res = res.multiply(h.divide(BigDecimal.valueOf(3), MathContext.DECIMAL32));
        return res;
    }
}
