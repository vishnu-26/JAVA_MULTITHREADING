package even_odd_problem;

public class OddPrinter implements Runnable{
	
	Printer printerObj;
	
	public OddPrinter(Printer printerObj) {
		this.printerObj = printerObj;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			printerObj.printOdd();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
