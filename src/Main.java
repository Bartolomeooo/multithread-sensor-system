import system.SensorSystem;
import ui.SensorSystemWindow;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SensorSystem sensorSystem = new SensorSystem();
        sensorSystem.startSensors();

        SwingUtilities.invokeLater(() -> {
            SensorSystemWindow display = new SensorSystemWindow(sensorSystem.getBuffer());
            display.setVisible(true);
        });
    }
}
