import java.util.*;

public class Consumer implements Runnable {

    private Buffer<Date>  buffer;

    public Consumer(Buffer<Date> buffer){
        this.buffer=buffer;
    }

    @Override
    public void run() {

        Date message;
        while (true){

            System.out.println("Counsumeris trying to remove ");
            message = buffer.remove();

        }

    }
}
