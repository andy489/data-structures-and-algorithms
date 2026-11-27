// https://leetcode.com/problems/print-in-order/

// Solution: Semaphores — O(1) time, O(1) space
import java.util.concurrent.Semaphore;

class Foo {
    private Semaphore s2 = new Semaphore(0);
    private Semaphore s3 = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        s2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s2.acquire();
        printSecond.run();
        s3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s3.acquire();
        printThird.run();
    }
}
