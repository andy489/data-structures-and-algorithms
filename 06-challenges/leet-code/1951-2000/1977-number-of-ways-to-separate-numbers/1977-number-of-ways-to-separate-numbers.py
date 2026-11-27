# https://leetcode.com/problems/number-of-ways-to-separate-numbers/

class Solution:
    def numberOfCombinations(self, num: str) -> int:
        MOD = 10 ** 9 + 7
        n = len(num)
        if num[0] == '0':
            return 0

        # lcp[i][j] = length of common prefix of num[i:] and num[j:]
        lcp = [[0] * (n + 1) for _ in range(n + 1)]
        for i in range(n - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if num[i] == num[j]:
                    lcp[i][j] = lcp[i + 1][j + 1] + 1
                else:
                    lcp[i][j] = 0

        # dp[i][j]: splits of num[0..i] with last number starting at j
        # prefix[i][j]: prefix sum of dp[i][0..j]
        dp = [[0] * n for _ in range(n)]
        prefix = [[0] * n for _ in range(n)]

        for i in range(n):
            for j in range(i + 1):
                if num[j] == '0':
                    dp[i][j] = 0
                elif j == 0:
                    dp[i][j] = 1
                else:
                    length = i - j + 1
                    lo = max(0, j - length)
                    range_sum = prefix[j - 1][j - 1] - (prefix[j - 1][lo - 1] if lo > 0 else 0)
                    # For equal-length starts at k = j - length
                    k = j - length
                    if lo == k and k >= 0 and num[k] != '0':
                        common = lcp[k][j]
                        if common < length:
                            if num[k + common] > num[j + common]:
                                range_sum -= dp[j - 1][k]
                    dp[i][j] = range_sum % MOD
                prefix[i][j] = ((prefix[i][j - 1] if j > 0 else 0) + dp[i][j]) % MOD

        return prefix[n - 1][n - 1]
