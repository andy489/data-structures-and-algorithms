# https://leetcode.com/problems/find-the-largest-almost-missing-integer/

from collections import defaultdict

class Solution:
    def largestInteger(self, nums: list[int], k: int) -> int:
        n = len(nums)
        count = defaultdict(int)
        for start in range(n - k + 1):
            for v in set(nums[start:start + k]):
                count[v] += 1
        ans = -1
        for v, c in count.items():
            if c == 1:
                ans = max(ans, v)
        return ans
