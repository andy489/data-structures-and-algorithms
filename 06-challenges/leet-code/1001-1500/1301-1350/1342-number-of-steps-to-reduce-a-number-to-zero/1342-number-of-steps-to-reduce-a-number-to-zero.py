# https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

class Solution:
    def numberOfSteps(self, num: int) -> int:
        steps = 0
        while num:
            steps += 1 + (num & 1) if num > 1 else 1
            num >>= 1
        return steps
