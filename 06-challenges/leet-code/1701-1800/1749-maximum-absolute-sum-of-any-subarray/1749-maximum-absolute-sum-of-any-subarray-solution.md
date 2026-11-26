# 1749. Maximum Absolute Sum of Any Subarray — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/

---

## Solution: Max and Min Subarray Sum — O(n) time, O(1) space

**Idea:** The maximum absolute subarray sum is `max(maxSubarraySum, -minSubarraySum)`. Run Kadane's algorithm twice — once for max sum, once for min sum.

**Algorithm:**
1. Run Kadane's for maximum subarray sum → `maxSum`.
2. Run Kadane's for minimum subarray sum → `minSum`.
3. Return `max(maxSum, -minSum)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two linear passes |
| Space | O(1) |
