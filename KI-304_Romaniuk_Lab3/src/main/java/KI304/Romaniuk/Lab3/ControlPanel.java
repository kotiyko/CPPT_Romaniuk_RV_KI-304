package KI304.Romaniuk.Lab3;

/**
 * Клас, що моделює панель керування плити.
 */
public class ControlPanel {
    private boolean locked;

    public ControlPanel() {
        this.locked = false;
    }

    public boolean isLocked() {
        return locked;
    }

    public void lock() {
        this.locked = true;
    }

    public void unlock() {
        this.locked = false;
    }
}
