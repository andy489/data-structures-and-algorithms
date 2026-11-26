# 3046. Split The Array

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/split-the-array/

---

## Problem Statement

You are given an integer array `nums` of even length. You have to split the array into two parts `nums1` and `nums2` such that:

- `nums1.length == nums2.length == nums.length / 2`.
- `nums1` should contain distinct elements.
- `nums2` should contain distinct elements.

Return `true` if it is possible to split the array, and `false` otherwise.

---

## Examples

**Example 1:**
```
Input:  nums = [1,1,2,2,3,4]
Output: true
```
Explanation: nums1=[1,2,3], nums2=[1,2,4] both distinct.

**Example 2:**
```
Input:  nums = [1,1,1,1]
Output: false
```
Explanation: Cannot split since 1 appears 4 times; each half can hold at most one 1.

---

## Constraints

- `1 <= nums.length <= 100`
- `nums.length % 2 == 0`
- `1 <= nums[i] <= 100`
