# https://leetcode.com/problems/sort-integers-by-the-power-value/

from functools import lru_cache

class Solution:
    def getKth(self, lo: int, hi: int, k: int) -> int:
        @lru_cache(maxsize=None)
        def power(x):
            return 0 if x == 1 else 1 + power(x//2 if x%2==0 else 3*x+1)
        return sorted(range(lo, hi+1), key=lambda x: (power(x), x))[k-1]
