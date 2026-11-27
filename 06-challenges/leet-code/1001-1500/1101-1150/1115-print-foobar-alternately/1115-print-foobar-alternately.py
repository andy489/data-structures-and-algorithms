# https://leetcode.com/problems/print-foobar-alternately/

import threading

# Solution: Semaphores — O(n) time, O(1) space
class FooBar:
    def __init__(self, n):
        self.n = n
        self.foo_sem = threading.Semaphore(1)
        self.bar_sem = threading.Semaphore(0)

    def foo(self, printFoo: 'Callable[[], None]') -> None:
        for _ in range(self.n):
            self.foo_sem.acquire()
            printFoo()
            self.bar_sem.release()

    def bar(self, printBar: 'Callable[[], None]') -> None:
        for _ in range(self.n):
            self.bar_sem.acquire()
            printBar()
            self.foo_sem.release()
