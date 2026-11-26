# https://leetcode.com/problems/number-of-good-pairs/

class Solution:
    def numIdenticalPairs(self, nums) -> int:
        count = {}
        result = 0
        for num in nums:
            result += count.get(num, 0)
            count[num] = count.get(num, 0) + 1
        return result
