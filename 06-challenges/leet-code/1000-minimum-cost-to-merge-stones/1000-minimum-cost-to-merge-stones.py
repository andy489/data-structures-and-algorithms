# https://leetcode.com/problems/minimum-cost-to-merge-stones/

# Solution: Interval DP with Prefix Sums — O(n³/k) time, O(n²) space
class Solution:
    def mergeStones(self, stones: list[int], k: int) -> int:
        n = len(stones)
        # each merge reduces pile count by (k-1); need (n-1) total reductions
        if (n - 1) % (k - 1) != 0:
            return -1

        # prefix[i+1] = sum of stones[0..i] for O(1) range sum queries
        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + stones[i]

        # dp[i][j] = min cost to reduce stones[i..j] to the minimum possible piles
        dp = [[0] * n for _ in range(n)]

        for length in range(k, n + 1):
            for i in range(n - length + 1):
                j = i + length - 1
                dp[i][j] = float('inf')
                # step by (k-1): left part stones[i..m] must be reducible to 1 pile,
                # which requires (m-i) % (k-1) == 0, so m = i, i+(k-1), i+2(k-1), ...
                for m in range(i, j, k - 1):
                    dp[i][j] = min(dp[i][j], dp[i][m] + dp[m + 1][j])
                # if stones[i..j] can be reduced to exactly 1 pile, add the final merge cost
                if (j - i) % (k - 1) == 0:
                    dp[i][j] += prefix[j + 1] - prefix[i]

        return dp[0][n - 1]
