# 88. Merge Sorted Array — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/merge-sorted-array/

---

## Solution: Three Pointers from the End — O(m + n) time, O(1) space

**Idea:** Merging from the front would require shifting elements right whenever a `nums2` element is smaller. Instead, fill `nums1` from the back: the largest available value among the two arrays occupies the last position, so we never overwrite unprocessed data.

**Algorithm:**
1. Set `p1 = m - 1`, `p2 = n - 1`, `p = m + n - 1`.
2. While `p2 >= 0`:
   - If `p1 >= 0` and `nums1[p1] > nums2[p2]`, write `nums1[p1]` at `nums1[p]` and decrement `p1`.
   - Otherwise, write `nums2[p2]` at `nums1[p]` and decrement `p2`.
   - Decrement `p`.
3. When `p2 < 0` we are done — any remaining `nums1` elements are already in place.

**Complexity:**

| | |
|---|---|
| Time | O(m + n) — each element is written exactly once |
| Space | O(1) — in-place, no extra array |
