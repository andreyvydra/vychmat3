package org.example;

import org.example.functions.Function;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class OutputHelper {
    public static void printLogo() {
        System.out.println("Integrals");
    }

    public static void printEnterFunctionMessage(HashMap<Integer, Function> functionMap) {
        for (Map.Entry<Integer, Function> entry : functionMap.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
        System.out.print("Введите номер функции: ");
    }

    public static void printEnterMethodMessage() {
        System.out.println("1. Метод правый прямоугольников");
        System.out.println("2. Метод левых прямоугольников");
        System.out.println("3. Метод средних прямоугольников");
        System.out.println("4. Метод трапеций");
        System.out.println("5. Метод Симпсона");
        System.out.print("Введите номер метода: ");
    }

    public static void printEnterLeftBorderMessage() {
        System.out.print("Введите левую границу интегрирования: ");
    }

    public static void printEnterRightBorderMessage() {
        System.out.print("Введите правую границу интегрирования: ");
    }

    public static void printEnterEMessage() {
        System.out.print("Введите необходимую точность интегрирования: ");
    }

    public static void printNumberFormatError() {
        System.out.println("Введите число!");
    }

    public static void printGoodbye() {
        System.out.println("Пока!");
    }

    public static void printResult(BigDecimal splits, BigDecimal res) {
        System.out.printf("Количество разбиение - %f, результат - %f\n", splits, res);
    }
}
