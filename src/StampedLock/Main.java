package StampedLock;

import java.util.concurrent.locks.StampedLock;

public class Main {

    public static void main(String[] args) {

        SharedResource resource = new SharedResource();
        StampedLock lock = new StampedLock();

        Thread t0 = new Thread(() -> {
            resource.optimisticProducer(lock);
        });


        Thread t1 = new Thread(() -> {
            resource.writerConsumer(lock);
        });

        Thread t2 = new Thread(() -> {
            resource.optimisticProducer(lock);
        });

        t0.start();
        // t2.start();

        // Delay consumer slightly to cause conflict
        try { Thread.sleep(500); } catch (Exception e) {}
        t1.start();

        // try { Thread.sleep(2000); } catch (Exception e) {}
        // t2.start();
    }
}
