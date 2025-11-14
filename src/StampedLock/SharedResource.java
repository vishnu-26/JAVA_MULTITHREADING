package StampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    private int a = 10;
    

    public void optimisticProducer(StampedLock lock) {

        long stamp = lock.tryOptimisticRead();     // no blocking
        System.out.println(Thread.currentThread().getName() +" → Took Optimistic Read Lock. Current Value = " + a);


        /*Take a Local Copy Before Sleep because 
        If writer thread modifies a after you took the optimistic read, 
        and if validation succeeds (which it shouldn’t, but may happen if timing mismatches),
        then you will print the updated value of a, not the value that optimistic read saw.*/
        int local = a;

        try {
            Thread.sleep(500); // simulate some work with value
             if (lock.validate(stamp)) {
                System.out.println(Thread.currentThread().getName() +" VALIDATED successfully. No writer touched the resource.");
                System.out.println(Thread.currentThread().getName() +" Final Value Seen = " + local);
            } 
            else {
                System.out.println(Thread.currentThread().getName() +" VALIDATION FAILED! Writer modified resource, hence rolling back");
                a = 10;
            }
        } 
        catch (Exception e) {

        }

        
    
    
    }

    
    public void writerConsumer(StampedLock lock) {

        long stamp = lock.writeLock();   // blocks all readers
        System.out.println(Thread.currentThread().getName() +" WRITE lock acquired. Updating value...");

        try {
            a = a + 10; // modify shared variable
            Thread.sleep(1500);
        }
        catch(Exception e){}
        finally{
            lock.unlockWrite(stamp);
            System.out.println(Thread.currentThread().getName() +" WRITE lock released. Value = " + a);
        }
        
    }
}

