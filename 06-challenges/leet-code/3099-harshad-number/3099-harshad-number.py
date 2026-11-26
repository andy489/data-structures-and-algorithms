# https://leetcode.com/problems/harshad-number/

class Solution:
    def sumOfTheDigitsOfHarshadNumber(self, x: int) -> int:
        s = sum(int(d) for d in str(x))
        return s if x % s == 0 else -1
