package org.example;

import java.util.function.*;

public class Calculator {
    static Supplier<Calculator> instance = Calculator::new;

    public BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    /*
        Ошибка из-за отсутствия проверки на ноль для y.
     */
    public BinaryOperator<Integer> devide = (x, y) -> {
        if(y != 0) {
            return x / y;
        } else {
            System.out.println("На ноль делить нельзя!");
            return Integer.MIN_VALUE;
        }
    };

    public UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;
}