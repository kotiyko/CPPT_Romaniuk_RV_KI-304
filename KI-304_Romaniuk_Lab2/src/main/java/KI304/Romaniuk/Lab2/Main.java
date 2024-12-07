package KI304.Romaniuk.Lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

class Burner {
    private boolean isOn;
    private int temperature;

    public Burner() {
        this.isOn = false;
        this.temperature = 0;
    }

    public Burner(int temperature) {
        this.isOn = true;
        this.temperature = temperature;
    }

    public void turnOn(int temp) {
        this.isOn = true;
        this.temperature = temp;
    }

    public void turnOff() {
        this.isOn = false;
        this.temperature = 0;
    }

    public int getTemperature() {
        return isOn ? temperature : 0;
    }
}

class ControlPanel {
    private int timer;
    private boolean lock;

    public ControlPanel() {
        this.timer = 0;
        this.lock = false;
    }

    public ControlPanel(int timer) {
        this.timer = timer;
        this.lock = false;
    }

    public void setTimer(int minutes) {
        this.timer = minutes;
    }

    public void activateLock() {
        this.lock = true;
    }

    public void deactivateLock() {
        this.lock = false;
    }

    public int getTimer() {
        return timer;
    }

    public boolean isLocked() {
        return lock;
    }
}

class PowerSupply {
    private boolean isConnected;

    public PowerSupply() {
        this.isConnected = true;
    }

    public PowerSupply(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public void disconnect() {
        this.isConnected = false;
    }

    public boolean isPowerOn() {
        return isConnected;
    }
}

class CookingStove {
    private Burner burner;
    private ControlPanel controlPanel;
    private PowerSupply powerSupply;
    private PrintWriter logWriter;

    public CookingStove() throws IOException {
        this.burner = new Burner();
        this.controlPanel = new ControlPanel();
        this.powerSupply = new PowerSupply();
        this.logWriter = new PrintWriter(new FileWriter("stove_log.txt", true));
        logAction("Stove initialized with default settings.");
    }

    public CookingStove(Burner burner, ControlPanel controlPanel, PowerSupply powerSupply) throws IOException {
        this.burner = burner;
        this.controlPanel = controlPanel;
        this.powerSupply = powerSupply;
        this.logWriter = new PrintWriter(new FileWriter("stove_log.txt", true));
        logAction("Stove initialized with custom settings.");
    }

    private void logAction(String action) {
        logWriter.println(LocalDateTime.now() + ": " + action);
        logWriter.flush();
    }

    public void turnOnBurner(int temperature) {
        if (powerSupply.isPowerOn() && !controlPanel.isLocked()) {
            burner.turnOn(temperature);
            logAction("Burner turned on at " + temperature + " degrees.");
        } else {
            logAction("Failed to turn on burner.");
        }
    }

    public void turnOffBurner() {
        burner.turnOff();
        logAction("Burner turned off.");
    }

    public void setTimer(int minutes) {
        controlPanel.setTimer(minutes);
        logAction("Timer set to " + minutes + " minutes.");
    }

    public void lockControlPanel() {
        controlPanel.activateLock();
        logAction("Control panel locked.");
    }

    public void unlockControlPanel() {
        controlPanel.deactivateLock();
        logAction("Control panel unlocked.");
    }

    public void disconnectPower() {
        powerSupply.disconnect();
        logAction("Power supply disconnected.");
    }

    public int checkBurnerTemperature() {
        int temp = burner.getTemperature();
        logAction("Checked burner temperature: " + temp + " degrees.");
        return temp;
    }

    public void closeLogFile() {
        logAction("Closing log file.");
        logWriter.close();
    }

    public static void main(String[] args) {
        try {
            CookingStove stove = new CookingStove();
            stove.turnOnBurner(180);
            stove.setTimer(30);
            stove.lockControlPanel();
            stove.unlockControlPanel();
            stove.turnOffBurner();
            stove.disconnectPower();
            stove.closeLogFile();

            Burner customBurner = new Burner(200);
            ControlPanel customControlPanel = new ControlPanel(20);
            PowerSupply customPowerSupply = new PowerSupply(true);

            CookingStove customStove = new CookingStove(customBurner, customControlPanel, customPowerSupply);
            customStove.turnOnBurner(150);
            customStove.turnOffBurner();
            customStove.closeLogFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
