# https://leetcode.com/problems/find-the-k-or-of-an-array/

class Solution:
    def findKOr(self, nums: list[int], k: int) -> int:
        result = 0
        for b in range(31):
            if sum((num >> b) & 1 for num in nums) >= k:
                result |= (1 << b)
        return result
