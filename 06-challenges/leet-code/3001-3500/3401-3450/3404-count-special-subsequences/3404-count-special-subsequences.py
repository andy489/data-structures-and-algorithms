# https://leetcode.com/problems/count-special-subsequences/
from math import gcd

class Solution:
    def countSpecialSubsequences(self, nums: list[int]) -> int:
        n = len(nums)
        MAX_VAL = 1001

        # Build suffix counts
        suffix_count = [[0] * MAX_VAL for _ in range(n + 1)]
        for i in range(n - 1, -1, -1):
            for v in range(MAX_VAL):
                suffix_count[i][v] = suffix_count[i + 1][v]
            suffix_count[i][nums[i]] += 1

        ans = 0
        p_count = [0] * MAX_VAL

        for q in range(1, n - 2):
            if q >= 2:
                p_count[nums[q - 2]] += 1
            nq = nums[q]
            for r in range(q + 2, n - 1):
                nr = nums[r]
                g = gcd(nq, nr)
                aq, ar = nq // g, nr // g
                t = 1
                while t * aq < MAX_VAL:
                    a = t * aq
                    b = t * ar
                    if b < MAX_VAL:
                        ans += p_count[a] * suffix_count[r + 2][b]
                    t += 1

        return ans
