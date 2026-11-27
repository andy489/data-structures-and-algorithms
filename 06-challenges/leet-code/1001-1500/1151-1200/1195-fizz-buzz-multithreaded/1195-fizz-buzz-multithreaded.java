// https://leetcode.com/problems/fizz-buzz-multithreaded/

// Solution: Semaphores — O(n) time, O(1) space
class FizzBuzz {
    private int n;
    private Semaphore numSem = new Semaphore(1);
    private Semaphore fizzSem = new Semaphore(0);
    private Semaphore buzzSem = new Semaphore(0);
    private Semaphore fizzBuzzSem = new Semaphore(0);

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if (i % 15 != 0) {
                fizzSem.acquire();
                printFizz.run();
                numSem.release();
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if (i % 15 != 0) {
                buzzSem.acquire();
                printBuzz.run();
                numSem.release();
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            fizzBuzzSem.acquire();
            printFizzBuzz.run();
            numSem.release();
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            numSem.acquire();
            if (i % 15 == 0) fizzBuzzSem.release();
            else if (i % 3 == 0) fizzSem.release();
            else if (i % 5 == 0) buzzSem.release();
            else { printNumber.accept(i); numSem.release(); }
        }
    }
}
