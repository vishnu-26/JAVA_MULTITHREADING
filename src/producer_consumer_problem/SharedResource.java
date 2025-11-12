package producer_consumer_problem;
import java.util.*;

public class SharedResource {
	
	private Queue<Integer> sharedBuffer;
	private int bufferSize;
	
	public SharedResource(int bufferSize){
		sharedBuffer = new LinkedList<>();
		this.bufferSize = bufferSize;
	}
	
	
	public synchronized void ProduceItem(int item) throws InterruptedException {
		
		while(sharedBuffer.size()==bufferSize) {
			System.out.println("Shared Buffer is full, Waiting for consumer to consume...");
			wait();    //Releases monitor locks
		}
		
		sharedBuffer.add(item);
		System.out.println("Produced: "+item);
		notify();
		
	}
	
	public synchronized void ConsumeItem() throws InterruptedException {
		
		while(sharedBuffer.isEmpty()) {
			System.out.println("Shared Buffer is Empty, Waiting for Producer to produce...");
			wait();    //Releases monitor locks
		}
		
		int item = sharedBuffer.poll();
		System.out.println("Consumed: "+item);
		notify();
	}
	
	

}
