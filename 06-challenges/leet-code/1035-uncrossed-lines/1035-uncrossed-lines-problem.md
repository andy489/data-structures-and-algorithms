# 1035. Uncrossed Lines

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/uncrossed-lines/

---

## Problem Statement

You are given two integer arrays `nums1` and `nums2`. We write the integers of `nums1` and `nums2` (in the order they are given) on two separate horizontal lines.

We may draw connecting lines: a straight line connecting `nums1[i]` to `nums2[j]` such that `nums1[i] == nums2[j]`, and the line we draw does not intersect any other connecting lines.

Return the maximum number of connecting lines we can draw.

---

## Examples

**Example 1:**
```
Input:  nums1 = [1,4,2], nums2 = [1,2,4]
Output: 2
```

**Example 2:**
```
Input:  nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
Output: 3
```

---

## Constraints

- `1 <= nums1.length, nums2.length <= 500`
- `1 <= nums1[i], nums2[j] <= 2000`
