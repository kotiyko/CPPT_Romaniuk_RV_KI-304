package KI.Romaniuk.Lab4;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Програма-драйвер для тестування класу ExpressionCalculator.
 */
 class CalculatorDriver {

    public static void main(String[] args) {
        ExpressionCalculator calculator = new ExpressionCalculator();

        double x = 0.5;

        try (FileWriter writer = new FileWriter("result.txt")) {
            double result = calculator.calculate(x);
            writer.write("Результат обчислення для x = " + x + " дорівнює: " + result);
            System.out.println("Результат успішно записано у файл.");
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка обчислення: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Помилка запису у файл: " + e.getMessage());
        }


        }
    }

