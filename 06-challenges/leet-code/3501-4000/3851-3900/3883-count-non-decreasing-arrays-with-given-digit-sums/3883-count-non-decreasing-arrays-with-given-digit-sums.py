# https://leetcode.com/problems/count-non-decreasing-arrays-with-given-digit-sums/

from bisect import bisect_right
from itertools import accumulate

class Solution:
    def countArrays(self, digitSum: list[int]) -> int:
        MOD = 10 ** 9 + 7

        def digit_sum(x):
            s = 0
            while x > 0:
                s += x % 10
                x //= 10
            return s

        by_sum = [[] for _ in range(51)]
        for x in range(5001):
            s = digit_sum(x)
            if s <= 50:
                by_sum[s].append(x)

        cur = by_sum[digitSum[0]]
        dp = [1] * len(cur)

        for i in range(1, len(digitSum)):
            prev, prev_dp = cur, dp
            prefix = [0] + list(accumulate(prev_dp, lambda a, b: (a + b) % MOD))
            cur = by_sum[digitSum[i]]
            dp = [0] * len(cur)
            for j, val in enumerate(cur):
                idx = bisect_right(prev, val)
                dp[j] = prefix[idx]

        return sum(dp) % MOD
