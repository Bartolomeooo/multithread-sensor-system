package sensors;

import buffer.Buffer;
import java.util.Random;

public class TemperatureSensor extends Sensor {
    private Random random = new Random();

    public TemperatureSensor(Buffer buffer) {
        super(buffer);
    }

    @Override
    protected void updateData() {
        double temperature = 20 + 10 * random.nextDouble();
        buffer.updateTemperature(temperature);
    }
}