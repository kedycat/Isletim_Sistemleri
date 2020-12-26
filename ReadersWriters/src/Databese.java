import java.util.concurrent.Semaphore;
public class Databese implements RWLock {

    private int readerCount;
    private Semaphore mutex;
    private Semaphore db;

    public Databese() {
        readerCount = 0;
        mutex = new Semaphore(1);
        db = new Semaphore(1);

    }

    @Override
    public void acquireReadLockLock(int readerNum) {

        try {
            mutex.acquire();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ++readerCount;

        if (readerCount == 1) {
            try {
                db.acquire();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Reader" + readerNum + "is reading. Reader count = " + readerCount);

            mutex.release();

        }
    }

    @Override
    public void releaseReadLock(int readerNum) {

        try {
            mutex.acquire();
        } catch (Exception e) {
            e.printStackTrace();
        }
        --readerCount;
        if(readerCount==0){
            db.release();
        }
        System.out.println("Reader"+ readerNum+ "has been left. Reader count" + readerCount);

    }

    @Override
    public void acquireWriteLock(int writeNum) {
        try {
            db.acquire();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Writer "+writeNum+ "is writing ");
    }

    @Override
    public void releaseWriteLock(int writerNum) {
        System.out.println("Writer"+ writerNum+ "is done writing");
        db.release();
    }
}
