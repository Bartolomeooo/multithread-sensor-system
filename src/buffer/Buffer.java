package buffer;

import data.SensorData;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    private SensorData data;
    private Lock lock = new ReentrantLock();

    public Buffer() {
        this.data = new SensorData();
    }

    public void updateTemperature(double temperature) {
        lock.lock();
        try {
            data.setTemperature(temperature);
        } finally {
            lock.unlock();
        }
    }

    public void updateHumidity(double humidity) {
        lock.lock();
        try {
            data.setHumidity(humidity);
        } finally {
            lock.unlock();
        }
    }

    public void updatePressure(double pressure) {
        lock.lock();
        try {
            data.setPressure(pressure);
        } finally {
            lock.unlock();
        }
    }

    public SensorData getData() {
        lock.lock();
        try {
            return new SensorData(data.getTemperature(), data.getHumidity(), data.getPressure());
        } finally {
            lock.unlock();
        }
    }
}
