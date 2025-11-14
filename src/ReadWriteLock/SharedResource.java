package ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource {
    
    boolean isResourceAvailable = false;

    public void readResource(ReadWriteLock lock) {
        try {
            lock.readLock().lock();
            while (!isResourceAvailable) {
                System.out.println("Resource not available for reading. " + Thread.currentThread().getName() + " is waiting and unlocked read lock");
                lock.readLock().unlock();
                Thread.sleep(100); // Simulate waiting so that writer thread can proceed and write the resource
                lock.readLock().lock();  //Again acquire the read lock before checking the condition , to avoid ERROR "attempt to unlock read lock, not locked by current thread"
            }
            System.out.println("Finished reading resource by " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void writeResource(ReadWriteLock lock) {
        try {
            lock.writeLock().lock();
            Thread.sleep(8000);
            isResourceAvailable = true;
            System.out.println("Finished writing resource by " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.writeLock().unlock();
        }
    }


}
