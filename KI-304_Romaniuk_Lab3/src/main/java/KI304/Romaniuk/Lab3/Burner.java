package KI304.Romaniuk.Lab3;

/**
 * Клас, що моделює конфорку.
 */
public class Burner {
    private boolean isOn;
    private int temperature;

    public Burner() {
        this.isOn = false;
        this.temperature = 0;
    }

    public void turnOn(int temperature) {
        this.isOn = true;
        this.temperature = temperature;
        System.out.println("Burner turned on at " + temperature + " degrees.");
    }

    public void turnOff() {
        this.isOn = false;
        this.temperature = 0;
        System.out.println("Burner turned off.");
    }
}
