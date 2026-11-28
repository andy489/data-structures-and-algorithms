# https://leetcode.com/problems/minimum-operations-to-make-array-elements-zero/

class Solution:
    def minOperations(self, queries: list[list[int]]) -> int:
        total = 0
        for l, r in queries:
            steps = 0
            lo, hi = 1, 3
            level = 1
            while lo <= r:
                overlap_l = max(l, lo)
                overlap_r = min(r, hi)
                if overlap_l <= overlap_r:
                    steps += (overlap_r - overlap_l + 1) * level
                lo = hi + 1
                hi = hi * 4 + 3
                level += 1
            total += (steps + 1) // 2
        return total
