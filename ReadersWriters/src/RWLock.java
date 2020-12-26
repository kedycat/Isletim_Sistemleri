public interface RWLock {
     void acquireReadLockLock(int readerNum);
     void acquireWriteLock(int writeNum);
     void releaseReadLock(int readerNum);
     void releaseWriteLock(int writerNum);

}
