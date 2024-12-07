package KI.Romaniuk.Lab5;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        CotangentCalculator calculator = new CotangentCalculator();
        ResultFileHandler fileHandler = new ResultFileHandler();

        double x = 0.5; // Задайте значення для тестування
        double result;

        try {

            result = calculator.calculate(x);
            System.out.println("Розрахований результат: " + result);


            String textFilePath = "result.txt";
            String binaryFilePath = "result.bin";


            fileHandler.writeToTextFile(result, textFilePath);
            System.out.println("Результат записано у текстовий файл.");


            double textResult = fileHandler.readFromTextFile(textFilePath);
            System.out.println("Результат з текстового файлу: " + textResult);


            fileHandler.writeToBinaryFile(result, binaryFilePath);
            System.out.println("Результат записано у двійковий файл.");


            double binaryResult = fileHandler.readFromBinaryFile(binaryFilePath);
            System.out.println("Результат з двійкового файлу: " + binaryResult);

        } catch (ArithmeticException e) {
            System.err.println("Помилка обчислення: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Помилка роботи з файлом: " + e.getMessage());
        }
    }
}
