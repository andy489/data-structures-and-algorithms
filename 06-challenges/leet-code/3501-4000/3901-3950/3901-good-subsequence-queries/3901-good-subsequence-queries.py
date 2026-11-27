# https://leetcode.com/problems/good-subsequence-queries/
from math import gcd
from typing import List


class Solution:
    def goodSubsequenceQueries(self, nums: List[int], p: int, queries: List[List[int]]) -> int:
        n = len(nums)
        max_val = 50001
        cnt = [0] * max_val
        for v in nums:
            cnt[v] += 1

        def has_good():
            count_p = 0
            g = 0
            for m in range(p, max_val, p):
                if cnt[m] > 0:
                    count_p += cnt[m]
                    g = gcd(g, m // p)
            if count_p < 2 or g != 1:
                return False
            if count_p < n:
                return True
            # all n elements are multiples of p; check if any n-1 have gcd = p
            for m in range(p, max_val, p):
                if cnt[m] > 0:
                    temp_g = 0
                    for m2 in range(p, max_val, p):
                        c = cnt[m2] - (1 if m2 == m else 0)
                        if c > 0:
                            temp_g = gcd(temp_g, m2 // p)
                    if temp_g == 1:
                        return True
            return False

        result = 0
        for ind, val in queries:
            cnt[nums[ind]] -= 1
            nums[ind] = val
            cnt[val] += 1
            if has_good():
                result += 1
        return result
