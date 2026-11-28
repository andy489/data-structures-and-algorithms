# https://leetcode.com/problems/maximize-subarrays-after-removing-one-conflicting-pair/

class Solution:
    def maxSubarrays(self, n: int, conflictingPairs: list[list[int]]) -> int:
        m = len(conflictingPairs)
        by_b = [[] for _ in range(n + 1)]
        for i, (x, y) in enumerate(conflictingPairs):
            a, b = min(x, y), max(x, y)
            by_b[b].append((a, i))

        base_total = 0
        bonus = [0] * m
        t1, t2, t1_idx = 0, 0, -1

        for r in range(1, n + 1):
            for a, idx in by_b[r]:
                if a >= t1:
                    t2 = t1
                    t1, t1_idx = a, idx
                elif a > t2:
                    t2 = a
            base_total += r - t1
            if t1_idx >= 0:
                bonus[t1_idx] += t1 - t2

        return base_total + max(bonus)
