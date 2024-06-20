package homework;

public class Thread2 extends Thread {
    private int startNumber;
    private int endNumber;

    public Thread2(int startNumber, int endNumber) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    @Override
    public void run() {
        Main.countNumbersMultiThread(startNumber, endNumber);
    }
}
