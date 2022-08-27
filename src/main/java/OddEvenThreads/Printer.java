package OddEvenThreads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

@Setter
@Getter
@AllArgsConstructor
public class Printer implements Runnable{

    private final int step;
    private final State state;
    private int currentValue;
    private final PrinterType currentPrinterType;
    private final PrinterType nextPrinterType;
    private final int maxValue;

    @SneakyThrows
    @Override
    public void run() {

        while (currentValue<=maxValue)
        {
            synchronized (state) {
                while ((currentPrinterType != state.getNextToPrint()))
                      state.wait();
                System.out.println("with sync block -> " + currentPrinterType.toString() + ": " + currentValue);
                currentValue += step;
                state.setNextToPrint(this.nextPrinterType);
                state.notifyAll();

            }
        }

    }
}
