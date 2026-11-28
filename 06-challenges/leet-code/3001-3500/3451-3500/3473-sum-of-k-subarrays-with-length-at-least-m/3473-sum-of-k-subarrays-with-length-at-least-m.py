# https://leetcode.com/problems/sum-of-k-subarrays-with-length-at-least-m/

class Solution:
    def maxSum(self, nums: list[int], k: int, m: int) -> int:
        n = len(nums)
        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + nums[i]

        NEG_INF = float('-inf')
        # prev[i] = max sum using j-1 subarrays ending at or before index i
        prev = [NEG_INF] * (n + 1)
        prev[0] = 0

        for j in range(1, k + 1):
            curr = [NEG_INF] * (n + 1)
            best = NEG_INF  # max of prev[s] - prefix[s]
            for i in range(m, n + 1):
                s = i - m
                if prev[s] != NEG_INF:
                    best = max(best, prev[s] - prefix[s])
                if best != NEG_INF:
                    curr[i] = max(curr[i], best + prefix[i])
                if i > 0 and curr[i - 1] != NEG_INF:
                    curr[i] = max(curr[i], curr[i - 1])
            prev = curr

        return prev[n]
