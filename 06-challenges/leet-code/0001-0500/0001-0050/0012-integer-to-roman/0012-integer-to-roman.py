# https://leetcode.com/problems/integer-to-roman/

class Solution:
    def intToRoman(self, num: int) -> str:
        romans = ['I', 'IV', 'V', 'IX', 'X', 'XL', 'L', 'XC', 'C', 'CD', 'D', 'CM', 'M']
        numerals = [1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000]
        res = []

        for i in range(12, -1, -1):
            while num >= numerals[i]:
                res.append(romans[i])
                num -= numerals[i]

        return ''.join(res)
