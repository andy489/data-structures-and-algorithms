# https://leetcode.com/problems/palindrome-partitioning-iii/

class Solution:
    def palindromePartition(self, s: str, k: int) -> int:
        n = len(s)
        cost = [[0]*n for _ in range(n)]
        for length in range(2, n+1):
            for i in range(n-length+1):
                j = i+length-1
                cost[i][j] = cost[i+1][j-1] + (0 if s[i]==s[j] else 1)
        INF = float('inf')
        dp = [[INF]*(k+1) for _ in range(n)]
        for i in range(n): dp[i][1] = cost[0][i]
        for j in range(2, k+1):
            for i in range(j-1, n):
                for m in range(j-2, i):
                    if dp[m][j-1] != INF:
                        dp[i][j] = min(dp[i][j], dp[m][j-1]+cost[m+1][i])
        return dp[n-1][k]
