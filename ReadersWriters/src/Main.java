public class Main {
    public static final int NUM_OF_READERS =13;
    public static final int NUM_OF_WRİTTER=1;
    public static void  main(String [] args){

        RWLock databese = new Databese();
        Thread[] readerArray = new Thread[NUM_OF_READERS];
        Thread[] writterArray = new Thread[NUM_OF_WRİTTER];
        for (int i=0; i<NUM_OF_READERS;i++){
            readerArray[i] = new Thread(new Reader(i,databese));
            readerArray[i].start();
        }

        for (int i=0; i<NUM_OF_WRİTTER;i++){
            writterArray[i] = new Thread(new Writer(databese, i));
            writterArray[i].start();
        }

    }

}
