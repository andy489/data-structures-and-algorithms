# 3356. Zero Array Transformation II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/zero-array-transformation-ii/

---

## Solution: Binary Search + Difference Array — O((n + q) log q) time, O(n) space

**Idea:** The feasibility of using the first `k` queries is monotone: if `k` queries suffice, then `k+1` queries also suffice. This makes binary search over `k` valid.

For a given `k`, check feasibility using a difference array: apply the first `k` queries as range additions (each query `[l, r, val]` adds `val` to `diff[l]` and subtracts `val` from `diff[r+1]`). The prefix sum gives the total max-decrement available at each index. It's feasible if `coverage[i] >= nums[i]` for all `i`.

**Algorithm:**
1. Binary search on `k` in `[0, queries.length]`.
2. For each candidate `k`, build a difference array from the first `k` queries and check feasibility in O(n + k).
3. Return the smallest `k` for which it's feasible, or -1 if none works.

**Complexity:**

| | |
|---|---|
| Time | O((n + q) log q) — binary search over q values, each check is O(n + q) |
| Space | O(n) — difference array |
