# 1685. Sum of Absolute Differences in a Sorted Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/

---

## Solution: Prefix Sums — O(n) time, O(n) space

**Idea:** For sorted `nums[i]`, the sum of absolute differences is:
`result[i] = nums[i] * i - prefix[i] + (suffix[i] - nums[i] * (n - i))`

where `prefix[i]` is sum of elements before index `i`.

**Algorithm:**
1. Compute prefix sum array.
2. For each `i`, elements to the left contribute `nums[i]*i - prefix[i]` and elements to the right contribute `(total - prefix[i+1]) - nums[i]*(n-1-i)`.
3. Sum both contributions.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — result array |
