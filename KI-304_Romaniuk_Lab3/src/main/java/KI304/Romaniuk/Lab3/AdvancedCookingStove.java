package KI304.Romaniuk.Lab3;

import java.io.IOException;

/**
 * Клас, що розширює функціональність плити та реалізує механізми автоматичного вимкнення.
 */
public class AdvancedCookingStove extends CookingStove implements AutoOff {

    private boolean autoOffEnabled;

    /**
     * Конструктор за замовчуванням для розширеної плити.
     * @throws IOException якщо виникають проблеми з файлом.
     */
    public AdvancedCookingStove() throws IOException {
        super();
        this.autoOffEnabled = false;
        logAction("Advanced stove initialized.");
    }

    /**
     * Реалізація абстрактного методу для увімкнення конфорки.
     * @param temperature температура для увімкнення конфорки.
     */
    @Override
    public void turnOnBurner(int temperature) {
        if (powerSupply.isPowerOn() && !controlPanel.isLocked()) {
            burner.turnOn(temperature);
            logAction("Burner turned on at " + temperature + " degrees.");
        } else {
            logAction("Failed to turn on burner.");
        }
    }

    /**
     * Реалізація методу інтерфейсу для автоматичного вимкнення.
     * @param minutes кількість хвилин до автоматичного вимкнення.
     */
    @Override
    public void autoTurnOff(int minutes) {
        this.autoOffEnabled = true;
        logAction("Auto-off enabled for " + minutes + " minutes.");
        // Симуляція таймера (тільки як приклад)
        try {
            Thread.sleep(minutes * 1000); // Наприклад, кожна "хвилина" це 1 секунда
            turnOffBurner();
        } catch (InterruptedException e) {
            logAction("Auto-off interrupted.");
        }
    }

    /**
     * Вимкнення конфорки.
     */
    public void turnOffBurner() {
        burner.turnOff();
        logAction("Burner turned off.");
    }
}
