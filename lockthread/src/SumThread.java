import javax.sound.midi.Soundbank;
import java.util.concurrent.locks.ReentrantLock;

public class SumThread extends Thread {

    private int [] array;
    private MutableInteger sumValue;
    private ReentrantLock rLock;
    private int from;
    private int amount;
    private int id;


    public SumThread(int id, int [] array, MutableInteger result, int from,int amount,ReentrantLock rlock){
        this.id=id;
        this.array=array;
        this.sumValue=result;
        this.from=from;
        this.rLock=rlock;
        this.amount=amount;
        System.out.println("Hello I am "+id+ "from"+from+ "to:"+(from+amount-1));

    }

    @Override
    public void run() {
        int localSum = 0;
        int counter = 0;
        int idx = from;

        while(counter != amount && idx<array.length){

            localSum+=array[idx];
            idx++;
            counter++;
        }
        rLock.lock();
        sumValue.setValue(sumValue.getValue()+localSum);
        rLock.unlock();
    }
}
