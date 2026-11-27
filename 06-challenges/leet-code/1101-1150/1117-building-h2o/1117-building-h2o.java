// https://leetcode.com/problems/building-h2o/

// Solution: Semaphores — O(n) time, O(1) space
import java.util.concurrent.Semaphore;
import java.util.concurrent.CyclicBarrier;

class H2O {
    private Semaphore hSem = new Semaphore(2);
    private Semaphore oSem = new Semaphore(0);
    private CyclicBarrier barrier = new CyclicBarrier(3);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException, BrokenBarrierException {
        hSem.acquire();
        releaseHydrogen.run();
        try { barrier.await(); } catch (Exception e) {}
        oSem.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException, BrokenBarrierException {
        oSem.acquire(2);
        releaseOxygen.run();
        try { barrier.await(); } catch (Exception e) {}
        hSem.release(2);
    }
}
