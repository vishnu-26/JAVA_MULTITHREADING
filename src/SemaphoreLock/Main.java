package SemaphoreLock;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        SharedResource resource = new SharedResource();
        Semaphore lock = new Semaphore(2);

        Thread t0 = new Thread(() -> {
            resource.readResource(lock);
        });

        Thread t1 = new Thread(() -> {
            resource.readResource(lock);
        });

        Thread t2 = new Thread(() -> {
            resource.readResource(lock);
        });

        Thread t3 = new Thread(() -> {
            resource.readResource(lock);
        });

        t0.start();
        t1.start();
        t2.start();
        t3.start();



}

}
