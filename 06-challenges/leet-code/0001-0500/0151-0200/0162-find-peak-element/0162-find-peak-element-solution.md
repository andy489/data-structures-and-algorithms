# 162. Find Peak Element — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-peak-element/

---

## Solution: Binary Search — O(log n) time, O(1) space

**Idea:** At any `mid`, if `nums[mid] < nums[mid+1]` the right half must contain a peak (the values are increasing to the right, so either they keep increasing to the boundary −∞ or they start decreasing somewhere — either way a peak exists). Otherwise the left half including `mid` contains a peak. This shrinks the window to a single element.

**Algorithm:**
1. `lo = 0, hi = n-1`.
2. While `lo < hi`: `mid = (lo+hi)/2`.
   - If `nums[mid] < nums[mid+1]`: `lo = mid+1`.
   - Else: `hi = mid`.
3. Return `lo`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) |
| Space | O(1) |
