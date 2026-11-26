# https://leetcode.com/problems/rabbits-in-forest/

from collections import Counter
import math

class Solution:
    def numRabbits(self, answers: list[int]) -> int:
        total = 0
        for k, cnt in Counter(answers).items():
            group_size = k + 1
            groups = math.ceil(cnt / group_size)
            total += groups * group_size
        return total
