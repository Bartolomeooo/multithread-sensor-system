package system;

import sensors.*;
import buffer.Buffer;

public class SensorSystem {
    private Buffer buffer;
    private Sensor temperatureSensor;
    private Sensor humiditySensor;
    private Sensor pressureSensor;

    public SensorSystem() {
        buffer = new Buffer();
        temperatureSensor = new TemperatureSensor(buffer);
        humiditySensor = new HumiditySensor(buffer);
        pressureSensor = new PressureSensor(buffer);
    }

    public void startSensors() {
        temperatureSensor.start();
        humiditySensor.start();
        pressureSensor.start();
    }

    public Buffer getBuffer() {
        return buffer;
    }
}
