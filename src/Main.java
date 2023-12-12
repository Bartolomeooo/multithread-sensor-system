import system.SensorSystem;
import ui.SensorDisplay;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SensorSystem sensorSystem = new SensorSystem();
        sensorSystem.startSensors();

        SwingUtilities.invokeLater(() -> {
            SensorDisplay display = new SensorDisplay(sensorSystem.getBuffer());
            display.setVisible(true);
        });
    }
}
