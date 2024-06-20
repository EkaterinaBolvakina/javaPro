package lessons.lesson_01_20_06_2024.task_04;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            Main.increment();
        }
    }
}
