# 1335. Minimum Difficulty of a Job Schedule — Solution

## Approach
DP: dp[day][i] = min difficulty scheduling first i+1 jobs in `day` days. Transition: try all splits.

## Complexity
- Time: O(d * n^2)
- Space: O(d * n)
