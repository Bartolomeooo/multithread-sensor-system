package sensors;

import buffer.Buffer;
import java.util.Random;

public class HumiditySensor extends Sensor {
    private Random random = new Random();

    public HumiditySensor(Buffer buffer) {
        super(buffer);
    }

    @Override
    protected void updateData() {
        double humidity = 100 * random.nextDouble();
        buffer.updateHumidity(humidity);
    }
}