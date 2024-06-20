package task_02;

public class Main {
    public static int counter;

    public static void main(String[] args) {
        for (int i = 0; i < 1_000_000; i++) {
            counter++;
        }
        System.out.println("Counter value: " + counter);
    }
}
