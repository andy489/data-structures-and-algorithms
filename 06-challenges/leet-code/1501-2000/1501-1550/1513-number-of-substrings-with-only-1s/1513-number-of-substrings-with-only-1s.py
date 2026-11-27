# https://leetcode.com/problems/number-of-substrings-with-only-1s/

class Solution:
    def numSub(self, s: str) -> int:
        MOD = 10 ** 9 + 7
        result = 0
        cur = 0
        for c in s:
            if c == '1':
                cur += 1
                result += cur
            else:
                cur = 0
        return result % MOD
