package org.example;

import org.example.functions.*;

import java.util.HashMap;
import java.util.Map;

public class FunctionStorage {
    private final Map<Integer, Function> functionMap = new HashMap<>();

    public FunctionStorage() {
        this.functionMap.put(1, new FunctionSin());
        this.functionMap.put(2, new FunctionVar());
        this.functionMap.put(3, new FunctionCos());
        this.functionMap.put(4, new FunctionSinCos());
        this.functionMap.put(5, new FunctionX());
    }

    public Map<Integer, Function> getFunctionMap() {
        return functionMap;
    }
}
