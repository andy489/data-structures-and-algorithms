# https://leetcode.com/problems/thousand-separator/

class Solution:
    def thousandSeparator(self, n: int) -> str:
        s = str(n)
        result = []
        for i, c in enumerate(s):
            rem = len(s) - i
            if i > 0 and rem % 3 == 0:
                result.append('.')
            result.append(c)
        return ''.join(result)
