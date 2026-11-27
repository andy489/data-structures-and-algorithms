# 870. Advantage Shuffle

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/advantage-shuffle/

---

## Problem Statement

You are given two integer arrays `nums1` and `nums2` both of the same length `n`.

The advantage of `nums1` with respect to `nums2` is the number of indices `i` for which `nums1[i] > nums2[i]`.

Return any permutation of `nums1` that maximizes its advantage with respect to `nums2`.

---

## Examples

**Example 1:**
```
Input:  nums1 = [2,7,11,15], nums2 = [1,10,4,11]
Output: [2,11,7,15]
```

**Example 2:**
```
Input:  nums1 = [12,24,8,32], nums2 = [13,25,32,11]
Output: [24,32,8,12]
```

---

## Constraints

- `n == nums1.length == nums2.length`
- `1 <= n <= 10^5`
- `0 <= nums1[i], nums2[i] <= 10^9`
