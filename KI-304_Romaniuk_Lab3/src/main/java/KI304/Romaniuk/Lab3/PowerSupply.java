package KI304.Romaniuk.Lab3;

/**
 * Клас, що моделює живлення плити.
 */
public class PowerSupply {
    private boolean powerOn;

    public PowerSupply() {
        this.powerOn = true;
    }

    public boolean isPowerOn() {
        return powerOn;
    }

    public void turnOffPower() {
        this.powerOn = false;
    }

    public void turnOnPower() {
        this.powerOn = true;
    }
}
