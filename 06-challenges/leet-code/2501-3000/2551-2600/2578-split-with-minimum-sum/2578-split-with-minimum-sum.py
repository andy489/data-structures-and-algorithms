# https://leetcode.com/problems/split-with-minimum-sum/

class Solution:
    def splitNum(self, num: int) -> int:
        digits = sorted(str(num))
        num1 = int(''.join(digits[0::2]))
        num2 = int(''.join(digits[1::2]))
        return num1 + num2
