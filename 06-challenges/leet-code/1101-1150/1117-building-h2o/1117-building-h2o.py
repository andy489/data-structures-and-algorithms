# https://leetcode.com/problems/building-h2o/

import threading

# Solution: Semaphores — O(n) time, O(1) space
class H2O:
    def __init__(self):
        self.h_sem = threading.Semaphore(2)
        self.o_sem = threading.Semaphore(0)
        self.barrier = threading.Barrier(3)

    def hydrogen(self, releaseHydrogen: 'Callable[[], None]') -> None:
        self.h_sem.acquire()
        releaseHydrogen()
        self.barrier.wait()
        self.o_sem.release()

    def oxygen(self, releaseOxygen: 'Callable[[], None]') -> None:
        self.o_sem.acquire()
        self.o_sem.acquire()
        releaseOxygen()
        self.barrier.wait()
        self.h_sem.release()
        self.h_sem.release()
