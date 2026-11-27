# 33. Search in Rotated Sorted Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/search-in-rotated-sorted-array/

---

## Solution: Modified Binary Search — O(log n) time, O(1) space

**Idea:** In a rotated sorted array, at every midpoint one of the two halves is guaranteed to be sorted. Determine which half is sorted, check if the target lies within that range, then narrow the search to the appropriate half.

**Algorithm:**
1. Initialize `lo = 0`, `hi = nums.length - 1`.
2. While `lo <= hi`, compute `mid = lo + (hi - lo) / 2`.
3. If `nums[mid] == target`, return `mid`.
4. Determine which half is sorted:
   - If `nums[lo] <= nums[mid]` → left half `[lo, mid]` is sorted:
     - If `nums[lo] <= target < nums[mid]` → search left: `hi = mid - 1`.
     - Else → search right: `lo = mid + 1`.
   - Else → right half `[mid, hi]` is sorted:
     - If `nums[mid] < target <= nums[hi]` → search right: `lo = mid + 1`.
     - Else → search left: `hi = mid - 1`.
5. Return `-1` if not found.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — binary search halves the search space each step |
| Space | O(1) — only pointer variables used |
