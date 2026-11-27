# https://leetcode.com/problems/remove-boxes/
# Solution: 3D interval DP — O(n^4) time, O(n^3) space
from functools import lru_cache

class Solution:
    def removeBoxes(self, boxes: list[int]) -> int:
        @lru_cache(maxsize=None)
        def dp(l, r, k):
            if l > r:
                return 0
            result = (k + 1) ** 2 + dp(l + 1, r, 0)
            for m in range(l + 1, r + 1):
                if boxes[m] == boxes[l]:
                    result = max(result, dp(l + 1, m - 1, 0) + dp(m, r, k + 1))
            return result

        return dp(0, len(boxes) - 1, 0)
