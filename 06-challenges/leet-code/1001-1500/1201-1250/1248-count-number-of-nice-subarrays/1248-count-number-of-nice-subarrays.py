# https://leetcode.com/problems/count-number-of-nice-subarrays/

class Solution:
    def numberOfSubarrays(self, nums: list[int], k: int) -> int:
        from collections import defaultdict
        count = defaultdict(int)
        count[0] = 1
        prefix = res = 0
        for x in nums:
            prefix += x & 1
            res += count[prefix - k]
            count[prefix] += 1
        return res
