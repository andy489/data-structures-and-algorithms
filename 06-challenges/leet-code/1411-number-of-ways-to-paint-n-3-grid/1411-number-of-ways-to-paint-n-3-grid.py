# https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/

class Solution:
    def numOfWays(self, n: int) -> int:
        MOD = 10**9 + 7
        aba, abc = 12, 6
        for _ in range(n - 1):
            aba, abc = (3 * aba + 2 * abc) % MOD, (2 * aba + 2 * abc) % MOD
        return (aba + abc) % MOD
