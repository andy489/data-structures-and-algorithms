# https://leetcode.com/problems/minimum-division-operations-to-make-array-non-decreasing/

class Solution:
    def minOperations(self, nums: list[int]) -> int:
        max_val = 1_000_001
        spf = list(range(max_val))
        i = 2
        while i * i < max_val:
            if spf[i] == i:
                for j in range(i * i, max_val, i):
                    if spf[j] == j:
                        spf[j] = i
            i += 1
        ops = 0
        for i in range(len(nums) - 2, -1, -1):
            if nums[i] > nums[i + 1]:
                nums[i] = spf[nums[i]]
                if nums[i] > nums[i + 1]:
                    return -1
                ops += 1
        return ops
