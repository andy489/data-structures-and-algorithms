# 1655. Distribute Repeating Integers — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/distribute-repeating-integers/

---

## Solution: Bitmask DP on Subsets of Customers — O(50 * 2^m) time, O(2^m) space

**Idea:** Since `m <= 10`, we can use a bitmask to represent subsets of customers. Precompute `need[mask]` = total quantity needed by that subset. Then iterate over frequency groups and greedily assign each group to subsets of customers it can cover.

**Algorithm:**
1. Count frequencies and collect distinct counts. Sort descending.
2. Precompute `need[mask]` for all 2^m subsets.
3. `dp[mask]` = `true` if the subset `mask` of customers has been fully satisfied.
4. `dp[0] = true`.
5. For each frequency `f`:
   - For each currently-achievable mask `s` (where `dp[s] == true`):
     - Try all subsets `t` of the remaining customers (complement of `s`) where `need[t] <= f`.
     - Set `dp[s | t] = true`.
6. Return `dp[(1<<m)-1]`.

**Complexity:**

| | |
|---|---|
| Time | O(50 * 3^m) — iterating submasks of complement |
| Space | O(2^m) |
