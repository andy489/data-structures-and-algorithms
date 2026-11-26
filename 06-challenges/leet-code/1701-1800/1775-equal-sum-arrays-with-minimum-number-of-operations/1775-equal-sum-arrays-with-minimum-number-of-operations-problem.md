# 1775. Equal Sum Arrays With Minimum Number of Operations

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/equal-sum-arrays-with-minimum-number-of-operations/

---

## Problem Statement

You are given two arrays of integers `nums1` and `nums2`, possibly of different lengths. The values in the arrays are between `1` and `6`, inclusive.

In one operation, you can change any integer's value in **any** of the arrays to **any** value between `1` and `6`, inclusive.

Return *the minimum number of operations required to make the sum of values in* `nums1` *equal to the sum of values in* `nums2`. Return `-1` if it is not possible to equalize the sums regardless of the number of operations.

---

## Examples

**Example 1:**
```
Input: nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
Output: 3
Explanation: You can make equal sum by changing:
nums1[0] to 2. nums1 = [2,2,3,4,5,6], sum = 22.
nums2[0] to 6. nums2 = [6,1,2,2,2,2], sum = 15.
nums1[0] to 2. nums1 = [2,2,3,4,5,6], sum = 22.
```

**Example 2:**
```
Input: nums1 = [1,1,1,1,1,1,1], nums2 = [6]
Output: -1
Explanation: There is no way to decrease the sum of nums1 or to increase the sum of nums2 to make them equal.
```

**Example 3:**
```
Input: nums1 = [6,6], nums2 = [1]
Output: 3
Explanation: You can make equal sum by changing:
nums2[0] to 2. nums2 = [2], sum = 2.
nums1[0] to 1. nums1 = [1,6], sum = 7.
nums1[1] to 5. nums1 = [1,5], sum = 6.
```

---

## Constraints

- `1 <= nums1.length, nums2.length <= 10^5`
- `1 <= nums1[i], nums2[i] <= 6`
