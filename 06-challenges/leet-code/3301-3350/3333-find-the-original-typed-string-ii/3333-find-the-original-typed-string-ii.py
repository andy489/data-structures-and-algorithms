# https://leetcode.com/problems/find-the-original-typed-string-ii/

class Solution:
    def possibleStringCount(self, word: str, k: int) -> int:
        MOD = 10**9 + 7
        # Build runs
        runs = []
        i = 0
        while i < len(word):
            j = i
            while j < len(word) and word[j] == word[i]:
                j += 1
            runs.append(j - i)
            i = j
        m = len(runs)
        # Total = product of all run lengths
        total = 1
        for r in runs:
            total = total * r % MOD
        if k <= m:
            return total
        # Count strings with length in [m, k-1]
        max_len = k - 1
        dp = [0] * (max_len + 1)
        dp[0] = 1
        for run_len in runs:
            new_dp = [0] * (max_len + 1)
            # prefix sum
            prefix = [0] * (max_len + 2)
            for j in range(max_len + 1):
                prefix[j + 1] = (prefix[j] + dp[j]) % MOD
            for j in range(1, max_len + 1):
                lo = max(0, j - run_len)
                hi = j - 1
                new_dp[j] = (prefix[hi + 1] - prefix[lo]) % MOD
            dp = new_dp
        bad = sum(dp[m:max_len + 1]) % MOD
        return (total - bad) % MOD
