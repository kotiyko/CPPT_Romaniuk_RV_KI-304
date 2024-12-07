package KI304.Romaniuk.Lab3;

import java.io.IOException;

/**
 * Клас-драйвер для тестування плити.
 */
public class TestCookingStove {
    public static void main(String[] args) {
        try {
            AdvancedCookingStove stove = new AdvancedCookingStove();
            stove.turnOnBurner(180); // Увімкнення конфорки
            stove.autoTurnOff(1); // Автоматичне вимкнення через 1 "хвилину" (симуляція)
            stove.closeLogFile(); // Закриття файлу логів
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
