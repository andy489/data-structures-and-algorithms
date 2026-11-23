# https://leetcode.com/problems/nth-digit/

class Solution:
    def findNthDigit(self, n: int) -> int:
        digits, start, count = 1, 1, 9
        while n > digits * count:
            n -= digits * count
            digits += 1
            start *= 10
            count *= 10
        num = start + (n - 1) // digits
        digit_index = (n - 1) % digits
        return int(str(num)[digit_index])
