# 1093. Statistics from a Large Sample — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/statistics-from-a-large-sample/

---

## Solution: Direct Computation — O(256) = O(1) time, O(1) space

**Idea:** Scan through count array to compute min, max, mode, total sum, and total count. For median, use prefix sums to find the middle element(s).

**Algorithm:**
1. Compute min (first nonzero), max (last nonzero), mode (max count index), total N, sum.
2. Mean = sum/N. Median: find N/2 and (N+1)/2 positions using cumulative counts.

**Complexity:**

| | |
|---|---|
| Time | O(256) = O(1) |
| Space | O(1) |
