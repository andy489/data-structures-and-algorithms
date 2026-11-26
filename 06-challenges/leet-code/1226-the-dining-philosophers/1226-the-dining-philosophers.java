// https://leetcode.com/problems/the-dining-philosophers/

// Solution: Semaphore with Asymmetric Lock Order — O(1) per call time, O(1) space
// Solution: Semaphore with Asymmetric Lock Order — O(1) per call time, O(1) space
class DiningPhilosophers {
    private final Semaphore[] forks = new Semaphore[5];
    private final Semaphore limit = new Semaphore(4);

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) forks[i] = new Semaphore(1);
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork, Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {
        limit.acquire();
        forks[philosopher].acquire();
        forks[(philosopher + 1) % 5].acquire();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        forks[philosopher].release();
        forks[(philosopher + 1) % 5].release();
        limit.release();
    }
}
