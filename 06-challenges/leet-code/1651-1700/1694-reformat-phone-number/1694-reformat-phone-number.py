# https://leetcode.com/problems/reformat-phone-number/

class Solution:
    def reformatNumber(self, number: str) -> str:
        digits = [c for c in number if c.isdigit()]
        result = []
        i, n = 0, len(digits)
        while n - i > 4:
            result.append(''.join(digits[i:i + 3]))
            i += 3
        if n - i == 4:
            result.append(''.join(digits[i:i + 2]))
            result.append(''.join(digits[i + 2:i + 4]))
        else:
            result.append(''.join(digits[i:]))
        return '-'.join(result)
