package task_01;

public class Main {
    public static void main(String[] args) {

        //1. Extend from class Thread
        //2. interface Runnable
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

        myThread1.start();

        //myThread2.run();
        Thread thread = new Thread(myThread2);
        //thread.start();

        // create Demon thread:
        thread.setDaemon(true);
        thread.start();


        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
