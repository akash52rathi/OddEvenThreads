package OddEvenThreads;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

@AllArgsConstructor
public class PrinterwithSemaphore implements Runnable{

    private final int step;
    private final State state;
    private int currentValue;
    private final PrinterType currentPrinterType;
    private final PrinterType nextPrinterType;
    private final int maxValue;
    private Semaphore semaphore;


    @SneakyThrows
    @Override
    public void run() {

        while (currentValue<=maxValue)
        {

                semaphore.acquire();
                if (this.currentPrinterType == state.getNextToPrint())
                {
                    System.out.println(currentPrinterType.toString() + ": " + currentValue);
                    currentValue += step;
                    state.setNextToPrint(this.nextPrinterType);

                }
                semaphore.release();

        }
    }
}
