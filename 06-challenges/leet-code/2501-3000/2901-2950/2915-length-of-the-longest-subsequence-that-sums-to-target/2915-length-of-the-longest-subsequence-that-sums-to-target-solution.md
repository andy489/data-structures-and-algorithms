# 2915. Length of the Longest Subsequence That Sums to Target — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/length-of-the-longest-subsequence-that-sums-to-target/

---

## Solution: 0/1 Knapsack DP — O(n * target) time, O(target) space

**Idea:** Use a 1D DP array where `dp[s]` = maximum number of elements in a subsequence with sum `s`. Initialize `dp[0] = 0` and all others to `-infinity`. For each element, update dp in reverse order (classic 0/1 knapsack).

**Algorithm:**
1. Initialize `dp[0] = 0`, `dp[1..target] = -infinity`.
2. For each `num` in `nums`, iterate `s` from `target` down to `num`.
3. If `dp[s - num] != -infinity`, update `dp[s] = max(dp[s], dp[s - num] + 1)`.
4. Return `dp[target]` if `> -infinity`, else `-1`.

**Complexity:**

| | |
|---|---|
| Time | O(n * target) |
| Space | O(target) |
