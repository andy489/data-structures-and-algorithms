# https://leetcode.com/problems/count-numbers-with-unique-digits/

class Solution:
    def countNumbersWithUniqueDigits(self, n: int) -> int:
        if n == 0:
            return 1
        count = 10
        unique = 9
        available = 9
        for _ in range(2, n + 1):
            unique *= available
            count += unique
            available -= 1
        return count
