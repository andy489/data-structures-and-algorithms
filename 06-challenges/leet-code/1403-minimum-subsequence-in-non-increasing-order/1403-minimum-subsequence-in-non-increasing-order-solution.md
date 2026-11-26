# 1403. Minimum Subsequence In Non Increasing Order — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/

---

## Solution: Sort Descending Greedy — O(n log n) time, O(n) space

**Idea:** Sort descending. Pick elements greedily until their sum exceeds the remaining sum.

**Algorithm:**
1. Compute `total = sum(nums)`. Sort descending.
2. Accumulate `subSum`; add element to result.
3. Stop when `subSum > total - subSum`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
