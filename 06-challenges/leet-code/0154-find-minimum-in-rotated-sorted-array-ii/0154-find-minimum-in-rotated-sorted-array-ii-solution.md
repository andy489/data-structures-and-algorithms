# 154. Find Minimum in Rotated Sorted Array II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

---

## Solution: Binary Search with Duplicate Handling — O(n) worst case, O(log n) average, O(1) space

**Idea:** Same binary search as 153, but when `nums[mid] == nums[hi]`, we cannot determine which half contains the minimum. The safe step is to shrink the right boundary by one (`hi--`). This degrades to O(n) in the worst case (all equal elements) but stays O(log n) on average.

**Algorithm:**
1. Init `lo = 0`, `hi = n - 1`.
2. While `lo < hi`:
   - `mid = (lo + hi) / 2`.
   - If `nums[mid] > nums[hi]`: minimum is in right half → `lo = mid + 1`.
   - Else if `nums[mid] < nums[hi]`: minimum is at or left of `mid` → `hi = mid`.
   - Else (`nums[mid] == nums[hi]`): can't tell → safely shrink `hi--`.
3. Return `nums[lo]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) worst case (all same), O(log n) average |
| Space | O(1) |
