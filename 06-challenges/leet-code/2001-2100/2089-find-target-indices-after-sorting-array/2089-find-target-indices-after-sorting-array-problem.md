# 2089. Find Target Indices After Sorting Array

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-target-indices-after-sorting-array/

---

## Problem Statement

You are given a 0-indexed integer array `nums` and a target element `target`. A **target index** is an index `i` such that `nums[i] == target`. Sort `nums` and return a list of target indices of the sorted array. The returned list must be sorted in increasing order.

---

## Examples

**Example 1:**
```
Input:  nums = [1,2,5,2,3], target = 2
Output: [1,2]
```
Explanation: Sorted: [1,2,2,3,5]. Target 2 at indices 1,2.

**Example 2:**
```
Input:  nums = [1,2,5,2,3], target = 3
Output: [3]
```
Explanation: Sorted: [1,2,2,3,5]. Target 3 at index 3.

**Example 3:**
```
Input:  nums = [1,2,5,2,3], target = 5
Output: [4]
```

---

## Constraints

- `1 <= nums.length <= 100`
- `1 <= nums[i], target <= 100`
