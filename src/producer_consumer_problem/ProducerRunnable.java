package producer_consumer_problem;

public class ProducerRunnable implements Runnable{
	
	SharedResource obj;
	
	public ProducerRunnable(SharedResource sharedResourceObj) {
		this.obj = sharedResourceObj;
	}

	@Override
	public void run() {
		
		
		for(int i=0;i<10;i++) {
			try {
				obj.ProduceItem(i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
