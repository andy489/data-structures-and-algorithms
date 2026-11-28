# 2918. Minimum Equal Sum of Two Arrays After Replacing Zeros

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/

---

## Problem Statement

You are given two arrays `nums1` and `nums2` consisting of positive integers.

You have to replace **all** the `0`'s in both arrays with **strictly** positive integers such that the sum of elements of both arrays becomes **equal**.

Return the **minimum** equal sum you can obtain, or `-1` if it is impossible.

---

## Examples

**Example 1:**
```
Input: nums1 = [3,2,0,1,0], nums2 = [6,5,0]
Output: 12
Explanation: Replace zeros in nums1 with 2 and 4, zeros in nums2 with 1. Both sum to 12.
```

**Example 2:**
```
Input: nums1 = [2,0,2,0], nums2 = [1,4]
Output: -1
```

---

## Constraints

- `1 <= nums1.length, nums2.length <= 10^5`
- `0 <= nums1[i], nums2[i] <= 10^6`
