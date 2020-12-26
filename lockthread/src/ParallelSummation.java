import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParallelSummation {

    public static void main(String [] args){

        Random rnd = new Random();
        int elementCount = 10000;
        int globalToplam=0;
        int [] array = new int[elementCount];
        int ThreadCount = 10;
        ReentrantLock rLock = new ReentrantLock();
        for (int i =0; i<array.length; i++){
            array[i]=rnd.nextInt(10);
        }

        MutableInteger [] sumValue=new MutableInteger[ThreadCount];
        MutableInteger sumValue2 = new MutableInteger(0);
        for(int i =0; i<sumValue.length; i++){

            sumValue[i] = new MutableInteger(0);

        }
        Thread[] sumThreads = new Thread[ThreadCount];

        int amount = elementCount/ThreadCount;
        for(int i =0; i <sumThreads.length; i++){

            sumThreads[i] = new SumThread(i,array,sumValue2,i*amount ,amount,rLock);
        }

        for(int i =0; i < sumThreads.length; i++){

            sumThreads[i].start();
        }
        for(int i =0; i < sumThreads.length; i++){

            try{
                sumThreads[i].join();
            } catch (InterruptedException ex){
                Logger.getLogger(ParallelSummation.class.getName()).log(Level.SEVERE,null, ex);
            }
        }

        /*for(int i =0;i<sumThreads.length; i++){
            globalToplam += sumValue[i].getValue();
        }*/
        System.out.println(sumValue2);

    }
}
