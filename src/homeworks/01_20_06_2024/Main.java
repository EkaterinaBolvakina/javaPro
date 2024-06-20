package homework;

public class Main {
    private static int counterMultiThread;

    private static int countNumbers(int StartNumber, int EndNumber) {
        int counter1 = 0;
        for (int i = StartNumber; i <= EndNumber; i++) {
            if (i % 21 == 0 && Integer.toString(i).contains("3")) {
                counter1++;
            }
        }
        return counter1;
    }

    public static synchronized void countNum(int StartNumber, int EndNumber) {
        counterMultiThread = counterMultiThread + countNumbers(StartNumber, EndNumber);
    }

    public static void main(String[] args) {

        Integer counterSingleThread = countNumbers(1, 2_000_000);
        System.out.println("Single-Threading result: " + counterSingleThread + " = count of numbers from range [1; 2_000_000] are divisible by 21 and contain the digit 3");

        countNum(1, 1_000_000);
        Thread2 thread2 = new Thread2();
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Multi-Threading result: " + counterMultiThread + " = count of numbers from range [1; 2_000_000] are divisible by 21 and contain the digit 3");

        if (counterSingleThread == counterMultiThread) {
            System.out.println("Correct results");
        } else {
            System.out.println("Everything is wrong....");
        }
    }
}
