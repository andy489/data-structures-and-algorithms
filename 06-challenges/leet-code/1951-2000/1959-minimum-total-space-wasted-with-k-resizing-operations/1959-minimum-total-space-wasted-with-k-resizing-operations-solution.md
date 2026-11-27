# 1959. Minimum Total Space Wasted With K Resizing Operations — Solution

## Approach

Dynamic programming. `dp[i][j]` = minimum space wasted for elements 0..i using j resizes.

For each segment [l..r], the optimal size is max(nums[l..r]) and the wasted space is max * (r - l + 1) - sum(nums[l..r]).

Precompute prefix sums and use a 2D DP table:
- `dp[i][j] = min over l: dp[l-1][j-1] + waste(l, i)`

Base case: dp[-1][0] = 0.

**Complexity:** O(n^2 * k) time, O(n * k) space.
