package sensors;

import buffer.Buffer;

public abstract class Sensor extends Thread {
    protected Buffer buffer;

    public Sensor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            updateData();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    protected abstract void updateData();
}
