package producer_consumer_problem;

public class ProducerConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SharedResource sharedResourceObj = new SharedResource(4);
		
		ProducerRunnable producerRunnableObj = new ProducerRunnable(sharedResourceObj);
		ConsumerRunnable consumerRunnableObj = new ConsumerRunnable(sharedResourceObj);
		
		Thread producerThread = new Thread(producerRunnableObj);
		Thread consumerThread = new Thread(consumerRunnableObj);
		
		producerThread.start();
		consumerThread.start();
		

	}

}
