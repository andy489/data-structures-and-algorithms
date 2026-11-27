# https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/

from collections import Counter
import math

class Solution:
    def minimumRounds(self, tasks: list[int]) -> int:
        freq = Counter(tasks)
        rounds = 0
        for cnt in freq.values():
            if cnt == 1:
                return -1
            rounds += math.ceil(cnt / 3)
        return rounds
