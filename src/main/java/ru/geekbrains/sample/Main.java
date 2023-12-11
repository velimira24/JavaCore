package ru.geekbrains.sample;

import ru.geekbrains.regular.Calculator;
import ru.geekbrains.regular.Decorator;

public class Main {
    public static void main(String[] args) {
        int result = Calculator.add(3, 3);
        System.out.println(Decorator.decorator(result));
        result = Calculator.sub(3, 3);
        System.out.println(Decorator.decorator(result));
        result = Calculator.mul(3, 3);
        System.out.println(Decorator.decorator(result));
        result = Calculator.div(3, 3);
        System.out.println(Decorator.decorator(result));
    }
}