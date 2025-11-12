package even_odd_problem;

public class Printer {
	
	private int counter;
	private int maxCounter;
	
	public Printer(int counter, int maxCounter) {
		this.counter = counter;
		this.maxCounter = maxCounter;
	}
	
	public synchronized void printOdd() throws InterruptedException {
		while(counter < maxCounter) {
			while(counter%2 == 0) {
				wait();
			}
			System.out.println("Odd Thread: "+counter);
			counter+=1;
			notifyAll();
			Thread.sleep(2000);
		}
		
		
	}
	
	public synchronized void printEven() throws InterruptedException {
		while(counter < maxCounter) {
			while(counter%2 == 1) {
				wait();
			}
			System.out.println("Even Thread: "+counter);
			counter+=1;
			notifyAll();
			
		}
		
	}

}
