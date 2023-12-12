package ui;

import javax.swing.*;
import java.awt.*;
import buffer.Buffer;
import data.SensorData;

public class SensorDisplay extends JFrame {
    private JLabel temperatureLabel;
    private JLabel humidityLabel;
    private JLabel pressureLabel;

    public SensorDisplay(Buffer buffer) {
        setTitle("Sensor Data Display");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);

        temperatureLabel = new JLabel("Loading...");
        add(temperatureLabel, constraints);

        constraints.gridx = 1;
        humidityLabel = new JLabel("Loading...");
        add(humidityLabel, constraints);

        constraints.gridx = 2;
        pressureLabel = new JLabel("Loading...");
        add(pressureLabel, constraints);

        Timer timer = new Timer(1000, e -> {
            SensorData data = buffer.getData();
            if (data != null) {
                temperatureLabel.setText("Temperature: " + String.format("%.2f °C", data.getTemperature()));
                humidityLabel.setText("Humidity: " + String.format("%.2f%%", data.getHumidity()));
                pressureLabel.setText("Pressure: " + String.format("%.2f hPa", data.getPressure()));
            }
        });
        timer.start();

        setVisible(true);
    }
}
