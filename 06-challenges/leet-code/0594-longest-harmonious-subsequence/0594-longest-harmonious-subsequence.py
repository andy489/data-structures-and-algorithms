# https://leetcode.com/problems/longest-harmonious-subsequence/
class Solution:
    def findLHS(self, nums: List[int]) -> int:
        frequency = {}
        for num in nums:
            frequency[num] = frequency.get(num, 0) + 1
        longest = 0
        for key in frequency:
            if key + 1 in frequency:
                longest = max(longest, frequency[key] + frequency[key + 1])
        return longest
