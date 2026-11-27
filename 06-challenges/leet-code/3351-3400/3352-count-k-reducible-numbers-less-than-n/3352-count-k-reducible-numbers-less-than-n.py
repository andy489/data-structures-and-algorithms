# https://leetcode.com/problems/count-k-reducible-numbers-less-than-n/

# Solution: Digit DP + Popcount Reduction Check — O(n^2) time, O(n^2) space
class Solution:
    def countKReducibleNumbers(self, s: str, k: int) -> int:
        MOD = 10 ** 9 + 7
        n = len(s)

        # Pascal's triangle for binomial coefficients
        C = [[0] * (n + 1) for _ in range(n + 1)]
        C[0][0] = 1
        for i in range(1, n + 1):
            C[i][0] = 1
            for j in range(1, i + 1):
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD

        # steps[c] = ops to reduce c to 1
        steps = [0] * (n + 1)
        for c in range(2, n + 1):
            steps[c] = 1 + steps[bin(c).count('1')]

        ans = 0
        for c in range(1, n + 1):
            if steps[c] >= k:
                continue
            ones_placed = 0
            for i, bit in enumerate(s):
                if bit == '1':
                    remaining = n - 1 - i
                    need = c - ones_placed
                    if 0 <= need <= remaining:
                        ans = (ans + C[remaining][need]) % MOD
                    ones_placed += 1
                if ones_placed > c:
                    break

        return ans
