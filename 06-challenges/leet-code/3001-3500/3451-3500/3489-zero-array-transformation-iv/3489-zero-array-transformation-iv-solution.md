# 3489. Zero Array Transformation IV — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/zero-array-transformation-iv/

---

## Solution: Binary Search + DP Subset Sum — O(q * n * V) time, O(n * V) space

**Idea:** Binary search on `k`. For a given `k`, check if the first `k` queries can zero the array. For each index `i`, the available decrement values are those `vali` where `li <= i <= ri` among the first `k` queries. Use subset-sum DP to check if `nums[i]` can be formed as a sum from available values.

**Algorithm:**
1. Binary search on k from 0 to `q`.
2. For each k, for each index i, collect all query values covering i.
3. Run subset-sum DP: `dp[s]` = true if sum `s` is achievable from the available values.
4. If `dp[nums[i]]` is true for all i, k is feasible.
5. Return the minimum feasible k, or -1 if none.

**Complexity:**

| | |
|---|---|
| Time | O(q * n * V) where V = max(nums[i]) |
| Space | O(n * V) |
