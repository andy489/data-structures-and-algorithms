# https://leetcode.com/problems/print-in-order/

import threading

# Solution: Semaphores — O(1) time, O(1) space
class Foo:
    def __init__(self):
        self.s2 = threading.Semaphore(0)
        self.s3 = threading.Semaphore(0)

    def first(self, printFirst: 'Callable[[], None]') -> None:
        printFirst()
        self.s2.release()

    def second(self, printSecond: 'Callable[[], None]') -> None:
        self.s2.acquire()
        printSecond()
        self.s3.release()

    def third(self, printThird: 'Callable[[], None]') -> None:
        self.s3.acquire()
        printThird()
