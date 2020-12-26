public class Writer implements Runnable {

    private RWLock databese;
    private int writterNum;

    public Writer(RWLock databese, int   writterNum){

        this.databese=databese;
        this.writterNum=writterNum;
    }

    @Override
    public void run() {
        while (true) {
            SleepUtilities.nap();
            System.out.println("writter "+writterNum+ "wants to write");
            databese.acquireWriteLock(writterNum);
            SleepUtilities.nap();
            databese.releaseWriteLock(writterNum);
        }
    }
}
