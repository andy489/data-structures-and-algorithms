# 870. Advantage Shuffle — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/advantage-shuffle/

---

## Solution: Greedy (Sorted Assignment) — O(n log n) time, O(n) space

**Idea:** Sort nums1. Process nums2 in decreasing order. For each nums2 element (by index sorted by value desc), use the largest nums1 that beats it; otherwise use the smallest remaining.

**Algorithm:**
1. Sort nums1.
2. Sort indices of nums2 by value descending.
3. Use two pointers (lo, hi) on sorted nums1.
4. For each nums2 index (high to low): if nums1[hi] > nums2[idx], assign hi-- (beats it); else assign lo++ (can't beat, waste smallest).
5. Build result array.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
