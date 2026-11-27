# 3355. Zero Array Transformation I — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/zero-array-transformation-i/

---

## Solution: Difference Array — O(n + q) time, O(n) space

**Idea:** Each query `[l, r]` can decrement any subset of elements in `[l, r]` by 1. The maximum total decrement available at index `i` is the number of queries that cover `i`. Since we can choose any subset, we can apply up to `coverage[i]` decrements at position `i`. The array can be zeroed if and only if `coverage[i] >= nums[i]` for all `i`.

Use a difference array to compute `coverage[i]` in O(n + q) time.

**Algorithm:**
1. Build a difference array `diff` of size `n+1`.
2. For each query `[l, r]`, do `diff[l]++` and `diff[r+1]--`.
3. Compute prefix sum of `diff` to get `coverage[i]`.
4. Return `true` if `coverage[i] >= nums[i]` for all `i`.

**Complexity:**

| | |
|---|---|
| Time | O(n + q) — one pass for diff array, one pass for prefix sum check |
| Space | O(n) — difference array |
