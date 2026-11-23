# 377. Combination Sum IV — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/combination-sum-iv/

---

## Solution: Bottom-Up DP — O(target × n) time, O(target) space

**Idea:** `dp[i]` = number of ways to form sum `i`. For each `i`, sum contributions from all `num` where `num <= i`.

**Algorithm:**
1. `dp[0] = 1` (empty combination).
2. For `i = 1..target`: `dp[i] = sum(dp[i - num] for each num in nums if num <= i)`.
3. Return `dp[target]`.

**Complexity:**

| | |
|---|---|
| Time | O(target × n) |
| Space | O(target) |
