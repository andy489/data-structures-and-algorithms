# 3041. Maximize Consecutive Elements in an Array After Modification — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximize-consecutive-elements-in-an-array-after-modification/

---

## Solution: Sort + DP — O(n log n) time, O(n) space

**Idea:** Sort the array. For each element we may keep it or bump it by 1. We want the
longest subsequence (using distinct final values) that forms a consecutive sequence.
Define `dp[v]` = the length of the longest consecutive sequence achievable ending at
value `v`. Process elements in sorted order: each `nums[i]` can land on `nums[i]` or
`nums[i]+1`. Placing it at value `v` extends the sequence ending at `v-1`, so:

- Place at `nums[i]`  : `dp[nums[i]] = dp[nums[i] - 1] + 1`  
- Place at `nums[i]+1`: `dp[nums[i]+1] = dp[nums[i]] + 1`

We update option B **after** option A in the same pass so a single element cannot
contribute to both transitions for the same `i`. Because the array is sorted, when
we see duplicates the assignment is correct: the later duplicate can only extend what
the earlier one already built.

**Algorithm:**
1. Sort `nums`.
2. Use a hash map `dp` (default 0).
3. For each `x` in sorted `nums`:
   - `dp[x + 1] = dp[x] + 1`  (place at x+1, extending sequence ending at x)
   - `dp[x]     = dp[x - 1] + 1`  (place at x, extending sequence ending at x-1)
   - Order matters: update `x+1` first so the current `dp[x]` still holds the
     value from previous elements before we overwrite it.
4. Return `max(dp.values())`.

**Complexity:**

| | |
|---|---|
| Time  | O(n log n) — sorting dominates; DP pass is O(n) |
| Space | O(n) — hash map stores at most 2n distinct values |
