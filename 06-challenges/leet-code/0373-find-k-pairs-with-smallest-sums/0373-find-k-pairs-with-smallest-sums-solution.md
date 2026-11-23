# 373. Find K Pairs with Smallest Sums — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

---

## Solution: Min-Heap — O(k log k) time, O(k) space

**Idea:** Seed the heap with pairs `(nums1[i], nums2[0])` for all `i` up to min(len, k). Each time we pop `(nums1[i], nums2[j])`, push `(nums1[i], nums2[j+1])` if it exists.

**Algorithm:**
1. Push `(nums1[i] + nums2[0], i, 0)` for `i = 0..min(k, len1)-1`.
2. Pop up to `k` times; for each pop `(_, i, j)`, record `[nums1[i], nums2[j]]` and push `(nums1[i] + nums2[j+1], i, j+1)` if `j+1 < len2`.

**Complexity:**

| | |
|---|---|
| Time | O(k log k) |
| Space | O(k) — heap and result |
