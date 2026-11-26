# https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/

class Solution:
    def minNumberOperations(self, target: list[int]) -> int:
        ops = target[0]
        for i in range(1, len(target)):
            if target[i] > target[i - 1]:
                ops += target[i] - target[i - 1]
        return ops
