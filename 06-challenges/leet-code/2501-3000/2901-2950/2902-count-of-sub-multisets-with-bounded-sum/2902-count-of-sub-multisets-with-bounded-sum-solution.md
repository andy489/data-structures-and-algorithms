# 2902. Count of Sub-Multisets With Bounded Sum — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-of-sub-multisets-with-bounded-sum/

---

## Solution: Bounded Knapsack DP with Frequency Map — O(r * distinct) time, O(r) space

**Idea:** Count the frequency of each distinct value. The number of zeros contributes a multiplier (zeros can be added freely). For each non-zero value `v` with count `c`, perform a bounded knapsack update: for each sum `s` from `v` to `r`, we can include 0 to `c` copies of `v`. Use a sliding window sum technique to do this efficiently.

**Algorithm:**
1. Count frequencies using a map; extract count of zeros separately as `zeroCount`.
2. Initialize `dp[0] = 1`, all other dp values 0.
3. For each distinct value `v` with count `c`, update dp using bounded knapsack with a prefix-sum sliding window to avoid O(r * c) per step.
4. The answer is `(zeroCount + 1) * sum(dp[l..r]) % MOD`.

**Complexity:**

| | |
|---|---|
| Time | O(r * distinct_values) |
| Space | O(r) |
