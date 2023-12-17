package ui;

import javax.swing.*;
import java.awt.*;
import buffer.Buffer;
import data.SensorData;

public class SensorSystemWindow extends JFrame {
    private JLabel temperatureLabel;
    private JLabel humidityLabel;
    private JLabel pressureLabel;
    private JLabel title;

    public SensorSystemWindow(Buffer buffer) {
        setTitle("Multithread Sensor System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        addTitle();
        addLabels();
        startTimer(buffer);

        setVisible(true);
    }

    private void addTitle() {
        title = new JLabel("Multithread Sensor System");
        title.setFont(new Font("Arial", Font.BOLD, 18));

        GridBagConstraints titleConstraints = new GridBagConstraints();
        titleConstraints.gridx = 0;
        titleConstraints.gridy = 0;
        titleConstraints.insets = new Insets(10, 10, 20, 10);

        add(title, titleConstraints);
    }

    private void addLabels() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.insets = new Insets(10, 10, 10, 10);

        temperatureLabel = new JLabel("Loading...");
        constraints.gridy = 1;
        add(temperatureLabel, constraints);

        humidityLabel = new JLabel("Loading...");
        constraints.gridy = 2;
        add(humidityLabel, constraints);

        pressureLabel = new JLabel("Loading...");
        constraints.gridy = 3;
        add(pressureLabel, constraints);
    }

    private void startTimer(Buffer buffer) {
        Timer timer = new Timer(1000, e -> {
            SensorData data = buffer.getData();
            if (data != null) {
                temperatureLabel.setText("Temperature: " + String.format("%6.2f °C", data.getTemperature()));
                humidityLabel.setText("Humidity: " + String.format("%6.2f%%", data.getHumidity()));
                pressureLabel.setText("Pressure: " + String.format("%6.2f hPa", data.getPressure()));
            }
        });
        timer.start();
    }
}
