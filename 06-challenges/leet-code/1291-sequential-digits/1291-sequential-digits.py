# https://leetcode.com/problems/sequential-digits/

class Solution:
    def sequentialDigits(self, low: int, high: int) -> list[int]:
        digits = "123456789"
        res = []
        for length in range(2, 10):
            for start in range(9 - length + 1):
                num = int(digits[start:start+length])
                if low <= num <= high:
                    res.append(num)
        return sorted(res)
