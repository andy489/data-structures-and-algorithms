# https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/

class Solution:
    def sumCounts(self, nums: list[int]) -> int:
        n = len(nums)
        ans = 0
        for i in range(n):
            seen = set()
            for j in range(i, n):
                seen.add(nums[j])
                ans += len(seen) ** 2
        return ans
