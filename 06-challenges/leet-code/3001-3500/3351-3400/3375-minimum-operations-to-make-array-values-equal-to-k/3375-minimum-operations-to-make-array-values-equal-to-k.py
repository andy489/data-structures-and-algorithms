# https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/

class Solution:
    def minOperations(self, nums: list[int], k: int) -> int:
        distinct = set()
        for x in nums:
            if x < k:
                return -1
            if x > k:
                distinct.add(x)
        return len(distinct)
