package even_odd_problem;

public class EevenPrinter implements Runnable{
	
	Printer printerObj;
	
	public EevenPrinter(Printer printerObj) {
		this.printerObj = printerObj;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			printerObj.printEven();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
