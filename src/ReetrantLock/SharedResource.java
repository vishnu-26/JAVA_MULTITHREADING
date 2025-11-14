package ReetrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
	
//	ReentrantLock lock = new ReentrantLock();
	boolean isAvailable = false;
	
	public void produce(ReentrantLock lock) {
		
		try {
			lock.lock();
			System.out.println("Lock acquired by : " + Thread.currentThread().getName());
			isAvailable = true;
			Thread.sleep(1000);
		}
		catch(Exception e) {
			
		}
		finally {
			System.out.println("Lock Released by : "+ Thread.currentThread().getName());
			lock.unlock();
//			System.out.println("Lock Released by : "+ Thread.currentThread().getName());
		}
	}

}
