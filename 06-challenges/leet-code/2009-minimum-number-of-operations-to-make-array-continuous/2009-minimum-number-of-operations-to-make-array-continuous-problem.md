# 2009. Minimum Number of Operations to Make Array Continuous

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/

---

## Problem Statement

You are given an integer array `nums`. In one operation, you can replace any element in `nums` with **any** integer. `nums` is considered **continuous** if both of the following conditions are met: all elements are **unique**, and the difference between the **maximum** and **minimum** element is exactly `n - 1`. Return the **minimum** number of operations to make `nums` continuous.

---

## Examples

**Example 1:**
```
Input:  nums = [4,2,5,3]
Output: 0
```
Explanation: Already continuous.

**Example 2:**
```
Input:  nums = [1,2,3,5,6]
Output: 1
```
Explanation: Change 5 to 4.

**Example 3:**
```
Input:  nums = [1,10,100,1000]
Output: 3
```
Explanation: Change three elements.

---

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
