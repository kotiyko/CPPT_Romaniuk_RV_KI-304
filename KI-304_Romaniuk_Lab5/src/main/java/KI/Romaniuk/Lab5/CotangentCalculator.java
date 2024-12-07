package KI.Romaniuk.Lab5;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Клас для обчислення виразу y = cot(8x) / x
 */
public class CotangentCalculator {

    /**
     * Обчислює вираз y = cot(8x) / x
     * @param x значення змінної x
     * @return результат обчислення
     * @throws ArithmeticException якщо x дорівнює нулю
     */
    public double calculate(double x) throws ArithmeticException {
        if (x == 0) {
            throw new ArithmeticException("Поділ на нуль!");
        }
        return 1 / Math.tan(8 * x) / x;
    }
}
