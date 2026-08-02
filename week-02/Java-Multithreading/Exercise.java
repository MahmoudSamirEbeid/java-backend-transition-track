// Task executed by multiple threads
class PrinterTask implements Runnable {

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": Running task " + i);
        }
    }
}

public class Exercise {

    public static void main(String[] args) throws InterruptedException {

        // Create one shared task
        PrinterTask task = new PrinterTask();

        // Create two threads
        Thread worker1 = new Thread(task, "Worker-1");
        Thread worker2 = new Thread(task, "Worker-2");

        // Start both threads
        worker1.start();
        worker2.start();

        // Wait for both threads to finish
        worker1.join();
        worker2.join();
    }
}