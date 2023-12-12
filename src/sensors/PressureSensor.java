package sensors;

import buffer.Buffer;
import java.util.Random;

public class PressureSensor extends Sensor {
    private Random random = new Random();

    public PressureSensor(Buffer buffer) {
        super(buffer);
    }

    @Override
    protected void updateData() {
        double pressure = 950 + 100 * random.nextDouble();
        buffer.updatePressure(pressure);
    }
}