# https://leetcode.com/problems/freedom-trail/

from collections import defaultdict

class Solution:
    def findRotateSteps(self, ring: str, key: str) -> int:
        n = len(ring)
        positions = defaultdict(list)
        for i, c in enumerate(ring):
            positions[c].append(i)

        from functools import lru_cache
        @lru_cache(maxsize=None)
        def dp(ki, ri):
            if ki == len(key):
                return 0
            best = float('inf')
            for nxt in positions[key[ki]]:
                diff = abs(ri - nxt)
                cost = min(diff, n - diff) + 1 + dp(ki + 1, nxt)
                best = min(best, cost)
            return best

        return dp(0, 0)
