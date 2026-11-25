# 801. Minimum Swaps To Make Sequences Increasing

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/

---

## Problem Statement

You are given two integer arrays of the same length `nums1` and `nums2`. In one operation, you are allowed to swap `nums1[i]` with `nums2[i]`.

Return the minimum number of needed operations to make `nums1` and `nums2` strictly increasing.

The test cases are generated such that the given input always makes it possible.

---

## Examples

**Example 1:**
```
Input:  nums1 = [1,3,5,4], nums2 = [1,2,3,7]
Output: 1
Explanation: Swap nums1[3] and nums2[3]: nums1 = [1,3,5,7], nums2 = [1,2,3,4].
```

**Example 2:**
```
Input:  nums1 = [0,3,5,8,9], nums2 = [2,1,4,6,9]
Output: 1
```

---

## Constraints

- `2 <= nums1.length <= 10^5`
- `0 <= nums1[i], nums2[i] <= 2 * 10^5`
