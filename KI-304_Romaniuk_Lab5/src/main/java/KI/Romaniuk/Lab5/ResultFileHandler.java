package KI.Romaniuk.Lab5;

import java.io.*;

/**
 * Клас для читання і запису результатів у текстовому і двійковому форматах.
 */
public class ResultFileHandler {

    /**
     * Записує результат у текстовий файл.
     * @param result результат для запису
     * @param filePath шлях до текстового файлу
     * @throws IOException у випадку помилки запису
     */
    public void writeToTextFile(double result, String filePath) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("Результат: " + result);
        }
    }

    /**
     * Читає результат із текстового файлу.
     * @param filePath шлях до текстового файлу
     * @return зчитаний результат
     * @throws IOException у випадку помилки читання
     */
    public double readFromTextFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line != null && line.startsWith("Результат: ")) {
                return Double.parseDouble(line.substring(10));
            } else {
                throw new IOException("Некоректний формат даних у файлі.");
            }
        }
    }

    /**
     * Записує результат у двійковий файл.
     * @param result результат для запису
     * @param filePath шлях до двійкового файлу
     * @throws IOException у випадку помилки запису
     */
    public void writeToBinaryFile(double result, String filePath) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            dos.writeDouble(result);
        }
    }

    /**
     * Читає результат із двійкового файлу.
     * @param filePath шлях до двійкового файлу
     * @return зчитаний результат
     * @throws IOException у випадку помилки читання
     */
    public double readFromBinaryFile(String filePath) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            return dis.readDouble();
        }
    }
}
