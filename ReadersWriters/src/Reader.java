public class Reader implements Runnable {

    private RWLock databese;
    private int readerNum;

    public Reader(int readerNUm, RWLock databese){

        this.databese=databese;
        this.readerNum=readerNUm;

    }

    @Override
    public void run() {
        while (true) {
            SleepUtilities.nap();
            System.out.println("Reader " + readerNum + "wants to read");
            databese.acquireReadLockLock(readerNum);
            SleepUtilities.nap();
            databese.releaseReadLock(readerNum);
        }
    }
}
