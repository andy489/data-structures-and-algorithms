# https://leetcode.com/problems/the-number-of-good-subsets/
class Solution:
    def numberOfGoodSubsets(self, nums: list[int]) -> int:
        MOD = 10 ** 9 + 7
        PRIMES = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]

        count = [0] * 31
        for x in nums:
            count[x] += 1

        prime_mask = [-1] * 31
        for v in range(2, 31):
            temp = v
            mask = 0
            valid = True
            for i, p in enumerate(PRIMES):
                if temp % p == 0:
                    mask |= (1 << i)
                    temp //= p
                    if temp % p == 0:
                        valid = False
                        break
            if valid:
                prime_mask[v] = mask

        dp = [0] * (1 << len(PRIMES))
        dp[0] = 1
        for v in range(2, 31):
            if count[v] == 0 or prime_mask[v] < 0:
                continue
            mask = prime_mask[v]
            for prev in range(len(dp) - 1, -1, -1):
                if dp[prev] == 0 or (prev & mask) != 0:
                    continue
                dp[prev | mask] = (dp[prev | mask] + dp[prev] * count[v]) % MOD

        result = sum(dp[1:]) % MOD
        pow2 = pow(2, count[1], MOD)
        return result * pow2 % MOD
