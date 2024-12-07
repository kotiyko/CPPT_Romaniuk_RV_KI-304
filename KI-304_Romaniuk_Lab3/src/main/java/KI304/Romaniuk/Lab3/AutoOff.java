package KI304.Romaniuk.Lab3;

/**
 * Інтерфейс для автоматичного вимкнення пристроїв.
 */
public abstract interface AutoOff {
    /**
     * Автоматичне вимкнення пристрою після певного часу.
     * @param minutes кількість хвилин до автоматичного вимкнення.
     */
    void autoTurnOff(int minutes);
}
