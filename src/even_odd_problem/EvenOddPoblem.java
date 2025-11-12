package even_odd_problem;

public class EvenOddPoblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Printer printerObj = new Printer(1,20);
		
		OddPrinter oddPrinterRunnable = new OddPrinter(printerObj);
		EevenPrinter evenPrinterRunnable = new EevenPrinter(printerObj);
		
		Thread oddThread = new Thread(oddPrinterRunnable);
		Thread evenThread = new Thread(evenPrinterRunnable);
		
		oddThread.start();
		evenThread.start();
		

	}

}
