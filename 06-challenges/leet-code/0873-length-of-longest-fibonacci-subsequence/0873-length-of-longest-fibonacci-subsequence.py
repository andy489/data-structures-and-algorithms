# https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/

class Solution:
    def lenLongestFibSubseq(self, arr: list[int]) -> int:
        idx = {v: i for i, v in enumerate(arr)}
        n = len(arr)
        dp = [[0] * n for _ in range(n)]
        ans = 0
        for j in range(n):
            for i in range(j + 1, n):
                diff = arr[i] - arr[j]
                if diff < arr[j] and diff in idx:
                    k = idx[diff]
                    dp[j][i] = dp[k][j] + 1
                    ans = max(ans, dp[j][i] + 2)
        return ans
