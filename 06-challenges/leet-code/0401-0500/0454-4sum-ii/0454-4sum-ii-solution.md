# 454. 4Sum II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/4sum-ii/

---

## Solution: HashMap — O(n²) time, O(n²) space

**Idea:** Compute all pairwise sums of nums1+nums2 and store in a frequency map. Then for each pair (nums3[k], nums4[l]), look up -(nums3[k]+nums4[l]) in the map.

**Algorithm:**
1. Build a frequency map `pairSums` for all `a + b` where `a ∈ nums1, b ∈ nums2`.
2. For every pair `(c, d)` from `nums3 × nums4`, add `pairSums.getOrDefault(-(c+d), 0)` to the result.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — two nested loops each of size n |
| Space | O(n²) — up to n² distinct pairwise sums |
