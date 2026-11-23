# https://leetcode.com/problems/random-pick-with-weight/

import random
import bisect

class Solution:
    def __init__(self, w: list[int]):
        self.prefix_sums = []
        total = 0
        for weight in w:
            total += weight
            self.prefix_sums.append(total)
        self.total_weight = total

    def pickIndex(self) -> int:
        target = random.randint(1, self.total_weight)
        return bisect.bisect_left(self.prefix_sums, target)
