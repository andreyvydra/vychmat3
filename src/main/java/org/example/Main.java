package org.example;

import org.example.functions.Function;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        FunctionStorage functionStorage = new FunctionStorage();
        HashMap<Integer, Function> functionMap = (HashMap<Integer, Function>) functionStorage.getFunctionMap();
        MethodStorage methodStorage = new MethodStorage();
        HashMap<Integer, Method> methods = methodStorage.getMethods();

        OutputHelper.printLogo();

        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                int numberOfFunction = getNumberOfFunction(scanner, functionMap);
                Function function = functionMap.get(numberOfFunction);

                int numberOfMethod = getNumberOfMethods(scanner);
                int k = 2;
                if (numberOfMethod == 5) {
                    k = 4;
                }

                BigDecimal a = getLeftBorder(scanner);
                methodStorage.setLeft(a);

                BigDecimal b = getRightBorder(scanner);
                methodStorage.setRight(b);

                BigDecimal e = getE(scanner);


                BigDecimal res1 = (BigDecimal) methods.get(numberOfMethod).invoke(methodStorage, function);
                OutputHelper.printResult(methodStorage.getSplits(), res1);
                methodStorage.setSplits(methodStorage.getSplits().multiply(BigDecimal.TWO));
                BigDecimal res2 = (BigDecimal) methods.get(numberOfMethod).invoke(methodStorage, function);
                OutputHelper.printResult(methodStorage.getSplits(), res2);

                while (res1.subtract(res2)
                        .divide(BigDecimal.valueOf(Math.pow(2, k) - 1), MathContext.DECIMAL32)
                        .abs().compareTo(e) > 0) {
                    res1 = res2;
                    methodStorage.setSplits(methodStorage.getSplits().multiply(BigDecimal.TWO));
                    res2 = (BigDecimal) methods.get(numberOfMethod).invoke(methodStorage, function);
                    OutputHelper.printResult(methodStorage.getSplits(), res2);
                }
                methodStorage.setSplits(BigDecimal.valueOf(4));
            }
        } catch (NoSuchElementException e) {
            OutputHelper.printGoodbye();
        }

    }

    public static Integer getNumberOfFunction(Scanner scanner, HashMap<Integer, Function> functionMap) {
        while (true) {
            try {
                OutputHelper.printEnterFunctionMessage(functionMap);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                OutputHelper.printNumberFormatError();
            }
        }
    }

    public static Integer getNumberOfMethods(Scanner scanner) {
        while (true) {
            try {
                OutputHelper.printEnterMethodMessage();
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                OutputHelper.printNumberFormatError();
            }
        }
    }

    public static BigDecimal getLeftBorder(Scanner scanner) {
        while (true) {
            try {
                OutputHelper.printEnterLeftBorderMessage();
                return BigDecimal.valueOf(Double.parseDouble(scanner.nextLine().replace(",", ".")));
            } catch (NumberFormatException e) {
                OutputHelper.printNumberFormatError();
            }
        }
    }

    public static BigDecimal getRightBorder(Scanner scanner) {
        while (true) {
            try {
                OutputHelper.printEnterRightBorderMessage();
                return BigDecimal.valueOf(Double.parseDouble(scanner.nextLine().replace(",", ".")));
            } catch (NumberFormatException e) {
                OutputHelper.printNumberFormatError();
            }
        }
    }

    public static BigDecimal getE(Scanner scanner) {
        while (true) {
            try {
                OutputHelper.printEnterEMessage();
                return BigDecimal.valueOf(Double.parseDouble(scanner.nextLine().replace(",", ".")));
            } catch (NumberFormatException ex) {
                OutputHelper.printNumberFormatError();
            }
        }
    }

}