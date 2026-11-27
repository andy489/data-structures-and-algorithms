# https://leetcode.com/problems/number-of-ways-to-split-a-string/

class Solution:
    def numWays(self, s: str) -> int:
        MOD = 10 ** 9 + 7
        ones = s.count('1')
        n = len(s)
        if ones % 3 != 0:
            return 0
        if ones == 0:
            return (n - 1) * (n - 2) // 2 % MOD
        third = ones // 3
        gap1 = gap2 = 0
        cnt = 0
        for c in s:
            if c == '1':
                cnt += 1
            if cnt == third:
                gap1 += 1
            elif cnt == 2 * third:
                gap2 += 1
        return gap1 * gap2 % MOD
