# 2926. Maximum Balanced Subsequence Sum — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-balanced-subsequence-sum/

---

## Solution: BIT / Fenwick Tree with Coordinate Compression — O(n log n) time, O(n) space

**Idea:** The balanced condition `nums[j] - nums[i] >= j - i` rearranges to `nums[j] - j >= nums[i] - i`. Define `a[i] = nums[i] - i`. The condition becomes: for two indices `i < j`, we need `a[j] >= a[i]`. So we want the maximum sum subsequence where the transformed values are non-decreasing.

Use DP: `dp[i]` = maximum balanced subsequence sum ending at index `i`. For each `i`, `dp[i] = nums[i] + max(0, max dp[j] for all j < i where a[j] <= a[i])`. Maintain a Fenwick tree (BIT) over coordinate-compressed `a` values, storing max DP values. Query prefix max up to `a[i]`, then update position `a[i]` with `dp[i]`.

**Algorithm:**
1. Compute `a[i] = nums[i] - i` for all `i`.
2. Coordinate-compress `a` values.
3. For each index `i` from left to right:
   - Query BIT for max DP value over all positions with `a[j] <= a[i]`.
   - `dp[i] = nums[i] + max(0, queryResult)`.
   - Update BIT at position of `a[i]` with `dp[i]`.
4. Return max of all `dp[i]`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
