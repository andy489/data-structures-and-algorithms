# https://leetcode.com/problems/linked-list-random-node/

# Solution: Reservoir Sampling — O(n) time, O(1) space
import random

class Solution:
    def __init__(self, head):
        self.head = head

    def getRandom(self) -> int:
        result = self.head.val
        cur = self.head.next
        k = 2

        while cur:
            if random.randint(1, k) == 1:
                result = cur.val
            cur = cur.next
            k += 1

        return result
