package SemaphoreLock;

import java.util.concurrent.Semaphore;

public class SharedResource {

    private int a = 10;

    public void readResource(Semaphore lock) {

        try {
            lock.acquire();
            System.out.println(Thread.currentThread().getName() +" Acquired Lock. Value = " + a);
            Thread.sleep(1000);
        } 
        catch (Exception e) {

        }
        finally{
            System.out.println(Thread.currentThread().getName() +" Released Lock");
            lock.release();
            
        }

}
}
