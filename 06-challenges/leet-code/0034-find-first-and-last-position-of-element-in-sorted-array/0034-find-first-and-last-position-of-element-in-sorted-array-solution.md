# 34. Find First and Last Position of Element in Sorted Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

---

## Solution: Two Binary Searches (Lower/Upper Bound) — O(log n) time, O(1) space

**Idea:** Run binary search twice — once to find the leftmost index where `target` appears (lower bound), and once to find the rightmost (upper bound). If the lower bound index is out of range or doesn't equal `target`, return `[-1, -1]`.

**Algorithm:**
1. **Lower bound** — binary search for the first index `i` such that `nums[i] >= target`:
   - While `lo <= hi`: if `nums[mid] < target` → `lo = mid + 1`, else → `hi = mid - 1`, record `mid` as candidate.
2. **Upper bound** — binary search for the last index `i` such that `nums[i] <= target`:
   - While `lo <= hi`: if `nums[mid] > target` → `hi = mid - 1`, else → `lo = mid + 1`, record `mid` as candidate.
3. If lower bound index is valid and `nums[lower] == target`, return `[lower, upper]`; otherwise return `[-1, -1]`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — two independent binary searches |
| Space | O(1) — only pointer variables used |
