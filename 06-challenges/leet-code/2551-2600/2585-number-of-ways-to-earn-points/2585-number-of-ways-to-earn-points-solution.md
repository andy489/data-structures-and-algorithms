# Solution: 2585. Number of Ways to Earn Points

## Approach: Bounded Knapsack DP

This is a classic **bounded knapsack** problem.

**DP Definition:**
- `dp[j]` = number of ways to earn exactly `j` points.
- Initialize `dp[0] = 1`, all others = 0.

**Transitions:**
For each question type `(count, marks)`:
- For each total `j` from `target` down to `1` (1D DP, like 0/1 knapsack but bounded):
  - `dp[j] = sum(dp[j - k*marks] for k in [1, min(count, j//marks)])` + old `dp[j]`

Actually for bounded knapsack, we iterate in a specific way. We can use a prefix-sum optimization or simply iterate from target down to 0 for each type, limiting to `count` items.

**Standard Bounded Knapsack:**
- For each type `i`:
  - Create a new DP array.
  - For target `j`, consider using 0, 1, ..., min(count, j//marks) questions of this type.
  - Optimize with sliding window or just O(count) inner loop.

**Simple O(n * target * max_count) solution:**
- For each type, use a fresh copy and compute sums.

## Complexity

- **Time:** O(n * target * max_count) = O(50 * 1000 * 50) = O(2,500,000)
- **Space:** O(target)
