package pro.sky.calculator.service;

import org.springframework.stereotype.Service;


public interface CalculatorService {
    int plus(int num1, int num2);

    int minus(int num1, int num2);

    int multiply(int num1, int num2);

    int divie(int num1, int num2);
}
