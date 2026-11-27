# 1818. Minimum Absolute Sum Difference — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-absolute-sum-difference/

---

## Solution: Sorted Set + Binary Search — O(n log n) time, O(n) space

**Idea:** Compute the total absolute difference. For each index `i`, find the element in `nums1` (using binary search on a sorted copy) that is closest to `nums2[i]`. The best single replacement maximises the saving `|nums1[i] - nums2[i]| - |best - nums2[i]|`. Subtract the maximum saving from the total.

**Algorithm:**
1. Sort a copy of `nums1`.
2. Compute the total absolute difference.
3. For each index `i`, binary-search `sorted1` for `nums2[i]`; check the nearest neighbours and track the maximum saving.
4. Return `(total - maxSave) % MOD`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting + n binary searches |
| Space | O(n) — sorted copy of nums1 |
