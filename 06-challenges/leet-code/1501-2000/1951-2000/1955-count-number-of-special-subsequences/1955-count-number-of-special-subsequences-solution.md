# 1955. Count Number of Special Subsequences — Solution

## Approach

Dynamic programming. Track three counts:
- `dp[0]`: number of subsequences consisting of only 0s
- `dp[1]`: number of subsequences consisting of 0s followed by 1s
- `dp[2]`: number of complete special subsequences (0s, 1s, 2s)

For each element in nums:
- If nums[i] == 0: `dp[0] = 2 * dp[0] + 1` (extend all existing or start new)
- If nums[i] == 1: `dp[1] = 2 * dp[1] + dp[0]`
- If nums[i] == 2: `dp[2] = 2 * dp[2] + dp[1]`

**Complexity:** O(n) time, O(1) space.
