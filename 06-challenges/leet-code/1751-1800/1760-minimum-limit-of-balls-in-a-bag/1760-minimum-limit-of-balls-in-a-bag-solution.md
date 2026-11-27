# 1760. Minimum Limit of Balls in a Bag — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/

---

## Solution: Binary Search on Answer — O(n log(max)) time, O(1) space

**Idea:** Binary search on the penalty value (maximum balls in any bag). For a given candidate penalty `mid`, check if we can achieve it using at most `maxOperations` splits. To split a bag of size `x` into bags of at most `mid` balls, we need `ceil(x / mid) - 1` operations.

**Algorithm:**
1. Binary search `lo = 1`, `hi = max(nums)`.
2. For each `mid`, compute total operations needed: `sum of ceil(nums[i] / mid) - 1` for all `i`.
3. If total operations <= `maxOperations`, the penalty `mid` is feasible; search lower half.
4. Otherwise search upper half.
5. Return `lo` as the minimum feasible penalty.

**Complexity:**

| | |
|---|---|
| Time | O(n log(max)) — binary search over [1, max(nums)], each check is O(n) |
| Space | O(1) — only a few variables |
