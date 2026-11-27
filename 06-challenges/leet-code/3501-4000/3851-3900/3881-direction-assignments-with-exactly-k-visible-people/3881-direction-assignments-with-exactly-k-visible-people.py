# https://leetcode.com/problems/direction-assignments-with-exactly-k-visible-people/

from math import comb

class Solution:
    def directionAssignments(self, n: int, pos: int, k: int) -> int:
        MOD = 10 ** 9 + 7
        total = n - 1
        if k > total:
            return 0
        return 2 * comb(total, k) % MOD
