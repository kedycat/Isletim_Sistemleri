import java.util.*;

public class Producer implements Runnable {

    private Buffer<Date> buffer;

    public Producer(Buffer<Date> buffer){
        this.buffer=buffer;

    }

    @Override
    public void run() {
        Date message;

        while (true){

            System.out.println("Producer is trying to insert");
            message= new Date();
            buffer.insert(message);

        }
    }
}
