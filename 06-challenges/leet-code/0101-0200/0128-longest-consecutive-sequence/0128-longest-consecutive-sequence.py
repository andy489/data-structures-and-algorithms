# https://leetcode.com/problems/longest-consecutive-sequence/

# Solution: Hash Set — O(n) time, O(n) space
class Solution:
    def longestConsecutive(self, nums: list[int]) -> int:
        num_set = set(nums)
        ans = 0
        for n in num_set:
            if n - 1 not in num_set:
                length = 1
                while n + length in num_set:
                    length += 1
                ans = max(ans, length)
        return ans
