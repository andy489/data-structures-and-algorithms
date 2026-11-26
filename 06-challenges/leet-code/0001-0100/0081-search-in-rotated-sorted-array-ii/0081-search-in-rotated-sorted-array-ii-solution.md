# 81. Search in Rotated Sorted Array II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

---

## Solution: Binary Search with Duplicate Handling — O(log n) avg, O(n) worst time, O(1) space

**Idea:** Same as LC 33 (rotated binary search), but when `nums[lo] == nums[mid] == nums[hi]` we can't determine which half is sorted. Shrink both ends by one (`lo++; hi--`) to skip the ambiguous duplicates. This degrades to O(n) only when duplicates surround the pivot; the average case stays O(log n).

**Algorithm:**
1. `lo = 0`, `hi = n - 1`.
2. While `lo <= hi`:
   - `mid = lo + (hi - lo) / 2`. If `nums[mid] == target`, return `true`.
   - If `nums[lo] == nums[mid] == nums[hi]`: `lo++; hi--` (can't tell which side is sorted).
   - Else if left half is sorted (`nums[lo] <= nums[mid]`):
     - If `target` is in `[nums[lo], nums[mid])`, search left; else right.
   - Else right half is sorted: if `target` is in `(nums[mid], nums[hi]]`, search right; else left.
3. Return `false`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) average, O(n) worst case (all duplicates) |
| Space | O(1) |
