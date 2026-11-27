# https://leetcode.com/problems/count-number-of-balanced-permutations/

# Solution: DP + Combinatorics — O(10 * n * target) time, O(n * target) space
from math import comb

class Solution:
    def countBalancedPermutations(self, num: str) -> int:
        MOD = 10**9 + 7
        n = len(num)
        cnt = [0] * 10
        total = 0
        for ch in num:
            d = int(ch)
            cnt[d] += 1
            total += d
        if total % 2 != 0:
            return 0
        target = total // 2
        even_slots = (n + 1) // 2
        odd_slots = n // 2

        # dp[placed][sum] = number of ways to place digits so far
        dp = [[0] * (target + 1) for _ in range(even_slots + 1)]
        dp[0][0] = 1

        for d in range(10):
            c = cnt[d]
            if c == 0:
                continue
            ndp = [[0] * (target + 1) for _ in range(even_slots + 1)]
            for placed in range(even_slots + 1):
                for s in range(target + 1):
                    if dp[placed][s] == 0:
                        continue
                    for k in range(c + 1):
                        np = placed + k
                        ns = s + k * d
                        if np > even_slots or ns > target:
                            break
                        ndp[np][ns] = (ndp[np][ns] + dp[placed][s] * comb(c, k)) % MOD
            dp = ndp

        ans = dp[even_slots][target]
        # multiply by even_slots! * odd_slots!
        from math import factorial
        ans = ans * factorial(even_slots) % MOD * factorial(odd_slots) % MOD
        # divide by product of cnt[d]!
        for c in cnt:
            ans = ans * pow(factorial(c), MOD - 2, MOD) % MOD
        return ans
