# https://leetcode.com/problems/count-the-number-of-beautiful-subarrays/
class Solution:
    def beautifulSubarrays(self, nums: list[int]) -> int:
        prefix_count = {0: 1}
        xor = 0
        result = 0
        for num in nums:
            xor ^= num
            result += prefix_count.get(xor, 0)
            prefix_count[xor] = prefix_count.get(xor, 0) + 1
        return result
