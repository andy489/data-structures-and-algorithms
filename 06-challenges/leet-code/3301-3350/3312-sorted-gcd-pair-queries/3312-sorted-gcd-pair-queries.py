# https://leetcode.com/problems/sorted-gcd-pair-queries/

from typing import List
import bisect


class Solution:
    def gcdValues(self, nums: List[int], queries: List[int]) -> List[int]:
        max_val = max(nums)
        cnt = [0] * (max_val + 1)
        for x in nums:
            cnt[x] += 1
        for g in range(1, max_val + 1):
            for mult in range(2 * g, max_val + 1, g):
                cnt[g] += cnt[mult]
        pairs = [0] * (max_val + 1)
        for g in range(max_val, 0, -1):
            pairs[g] = cnt[g] * (cnt[g] - 1) // 2
            for mult in range(2 * g, max_val + 1, g):
                pairs[g] -= pairs[mult]
        prefix = [0] * (max_val + 1)
        for g in range(1, max_val + 1):
            prefix[g] = prefix[g - 1] + pairs[g]
        ans = []
        for q in queries:
            ans.append(bisect.bisect_right(prefix, q))
        return ans
