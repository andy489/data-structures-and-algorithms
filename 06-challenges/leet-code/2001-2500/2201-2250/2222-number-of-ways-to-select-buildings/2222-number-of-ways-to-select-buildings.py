# https://leetcode.com/problems/number-of-ways-to-select-buildings/
class Solution:
    def numberOfWays(self, s: str) -> int:
        zeros = ones = zero_one = one_zero = result = 0
        for c in s:
            if c == '0':
                result += zero_one
                one_zero += ones
                zeros += 1
            else:
                result += one_zero
                zero_one += zeros
                ones += 1
        return result
