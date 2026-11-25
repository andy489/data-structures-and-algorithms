# 1074. Number of Submatrices That Sum to Target — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/

---

## Solution: 2D Prefix Sum + HashMap — O(m²*n) time, O(m*n) space

**Idea:** Fix top and bottom row boundaries. For each pair, compute column prefix sums and use 1D subarray sum = target (prefix sum + HashMap).

**Algorithm:**
1. For each pair (r1, r2), compute col_sum[j] = sum of matrix[r1..r2][j].
2. Use 1D subarray sum technique: `prefix_sum → count` hashmap, count subarrays with sum = target.
3. Sum over all row pairs.

**Complexity:**

| | |
|---|---|
| Time | O(m²*n) |
| Space | O(m*n) |
