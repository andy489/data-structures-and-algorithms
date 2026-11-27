# 503. Next Greater Element II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/next-greater-element-ii/

---

## Problem Statement

Given a circular integer array `nums` (i.e., the next element of `nums[nums.length - 1]` is `nums[0]`), return the **next greater number** for every element in `nums`.

The next greater number of a number `x` is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return `-1` for this number.

---

## Examples

**Example 1:**
```
Input:  nums = [1,2,1]
Output: [2,-1,2]
```

**Example 2:**
```
Input:  nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
```

---

## Constraints

- `1 <= nums.length <= 10^4`
- `-10^9 <= nums[i] <= 10^9`
