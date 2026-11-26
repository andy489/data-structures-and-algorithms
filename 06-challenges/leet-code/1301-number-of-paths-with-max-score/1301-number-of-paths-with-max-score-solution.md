# 1301. Number of Paths with Max Score — Solution

## Approach
DP from bottom-right to top-left. dp[i][j] = (maxScore, count). Transition from right, down, diagonal.

## Complexity
- Time: O(n^2)
- Space: O(n^2)
