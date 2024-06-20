package homework;

public class Thread2 extends Thread {
    @Override
    public void run() {
        Main.countNum(1_000_001, 2_000_000);
    }
}
