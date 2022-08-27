package OddEvenThreads;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        final State state = new State(PrinterType.ODD);
        Semaphore s1 = new Semaphore(1);
//        final PrinterwithSemaphore oddPrinter = new PrinterwithSemaphore(1, state, 1, PrinterType.ODD, PrinterType.EVEN, 50,s1);
//        final PrinterwithSemaphore evenPrinter = new PrinterwithSemaphore(2, state, 2, PrinterType.EVEN, PrinterType.ODD, 50,s1);

        final Printer oddPrinter = new Printer(1, state, 1, PrinterType.ODD, PrinterType.EVEN, 50);
        final Printer evenPrinter = new Printer(2, state, 2, PrinterType.EVEN, PrinterType.ODD, 50);


        final Thread oddThread = new Thread(oddPrinter);
        final Thread evenThread = new Thread(evenPrinter);

        /// printing two number with synchronized block






        oddThread.start();
        evenThread.start();
    }
}
