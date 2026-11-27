# https://leetcode.com/problems/intersection-of-multiple-arrays/

class Solution:
    def intersection(self, nums: list[list[int]]) -> list[int]:
        count = [0] * 1001
        for arr in nums:
            for v in arr:
                count[v] += 1
        return [i for i in range(1, 1001) if count[i] == len(nums)]
