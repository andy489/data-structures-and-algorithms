# 2918. Minimum Equal Sum of Two Arrays After Replacing Zeros — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/

---

## Solution: Greedy Min Sum — O(n + m) time, O(1) space

**Idea:** Each zero must be replaced by at least 1. So the minimum possible sum of `nums1` is `sum1 + zeros1` (where `zeros1` is the count of zeros), and similarly for `nums2`. The minimum equal sum is `max(minSum1, minSum2)`. But this is only feasible if the array with the smaller minimum sum has at least one zero (to increase its sum to match). If an array has no zeros, its sum is fixed.

**Algorithm:**
1. Compute `sum1`, `zeros1`, `sum2`, `zeros2`.
2. `minSum1 = sum1 + zeros1`, `minSum2 = sum2 + zeros2`.
3. If `minSum1 == minSum2`, return that value.
4. If `minSum1 < minSum2`: need to increase sum1 to `minSum2`. Only possible if `zeros1 > 0`; return `minSum2`.
5. If `minSum2 < minSum1`: need to increase sum2 to `minSum1`. Only possible if `zeros2 > 0`; return `minSum1`.
6. Return `-1` if impossible.

**Complexity:**

| | |
|---|---|
| Time | O(n + m) |
| Space | O(1) |
