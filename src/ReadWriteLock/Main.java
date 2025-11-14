package ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        Thread Thread0 = new Thread(() -> {
            sharedResource.readResource(lock);
        });

        Thread Thread1 = new Thread(() -> {
            sharedResource.readResource(lock);
        });

        Thread Thread2 = new Thread(() -> {
            sharedResource.writeResource(lock);
        });


        Thread0.start();
        Thread1.start();

        // // Delay to ensure readers start first
        // try {
        //     Thread.sleep(200);
        // } catch (InterruptedException e) {
        //     Thread.currentThread().interrupt();
        // }

        Thread2.start();

    }

}
