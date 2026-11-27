# https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/

class Solution:
    def getSmallestString(self, n: int, k: int) -> str:
        result = []
        for i in range(n - 1, -1, -1):
            val = min(26, k - i)
            result.append(chr(ord('a') + val - 1))
            k -= val
        return ''.join(reversed(result))
