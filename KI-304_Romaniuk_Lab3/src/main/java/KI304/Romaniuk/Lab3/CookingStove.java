package KI304.Romaniuk.Lab3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * Абстрактний клас, що описує базову функціональність плити для приготування їжі.
 */
public abstract class CookingStove {
    protected Burner burner;
    protected ControlPanel controlPanel;
    protected PowerSupply powerSupply;
    protected PrintWriter logWriter;

    /**
     * Конструктор за замовчуванням для абстрактного класу.
     * @throws IOException якщо виникають проблеми з файлом.
     */
    public CookingStove() throws IOException {
        this.burner = new Burner();
        this.controlPanel = new ControlPanel();
        this.powerSupply = new PowerSupply();
        this.logWriter = new PrintWriter(new FileWriter("stove_log.txt", true));
        logAction("Stove initialized with default settings.");
    }

    /**
     * Метод для запису дії у файл логів.
     * @param action Дія, яку потрібно записати.
     */
    protected void logAction(String action) {
        logWriter.println(LocalDateTime.now() + ": " + action);
        logWriter.flush();
    }

    /**
     * Абстрактний метод для увімкнення конфорки, що має бути реалізований у підкласах.
     * @param temperature температура для увімкнення конфорки.
     */
    public abstract void turnOnBurner(int temperature);

    /**
     * Закриття файлу логів.
     */
    public void closeLogFile() {
        logAction("Closing log file.");
        logWriter.close();
    }
}
