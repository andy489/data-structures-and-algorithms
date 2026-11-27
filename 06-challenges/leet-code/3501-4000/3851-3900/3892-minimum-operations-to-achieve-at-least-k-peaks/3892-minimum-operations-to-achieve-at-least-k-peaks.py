# https://leetcode.com/problems/minimum-operations-to-achieve-at-least-k-peaks/
class Solution:
    def minOperations(self, nums: list[int], k: int) -> int:
        n = len(nums)
        if k == 0:
            return 0
        if k > n // 2:
            return -1

        best = float('inf')

        for s in range(n):
            cost = 0
            pos = s
            for _ in range(k):
                prev = (pos - 1) % n
                nxt = (pos + 1) % n
                need = max(nums[prev], nums[nxt]) + 1 - nums[pos]
                if need > 0:
                    cost += need
                pos = (pos + 2) % n
            best = min(best, cost)

        return best
