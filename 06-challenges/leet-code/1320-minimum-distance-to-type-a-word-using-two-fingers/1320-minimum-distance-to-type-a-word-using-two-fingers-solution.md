# 1320. Minimum Distance to Type a Word Using Two Fingers — Solution

## Approach
DP: dp[i][j] = min cost where one finger just typed word[current], other finger is at position i (or j for the other). Use 26 as "not placed".

## Complexity
- Time: O(n * 27^2)
- Space: O(27^2)
