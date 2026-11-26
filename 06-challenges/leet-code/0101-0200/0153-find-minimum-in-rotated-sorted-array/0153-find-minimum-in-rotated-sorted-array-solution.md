# 153. Find Minimum in Rotated Sorted Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

---

## Solution: Binary Search — O(log n) time, O(1) space

**Idea:** The minimum is at the inflection point where the array transitions from large values back to small values. Use binary search: if `nums[mid] > nums[hi]`, the minimum is in the right half; otherwise it's in the left half (including `mid`).

**Algorithm:**
1. Init `lo = 0`, `hi = n - 1`.
2. While `lo < hi`:
   - `mid = (lo + hi) / 2`.
   - If `nums[mid] > nums[hi]`: minimum is to the right → `lo = mid + 1`.
   - Else: minimum is at or to the left of `mid` → `hi = mid`.
3. Return `nums[lo]`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) |
| Space | O(1) |
