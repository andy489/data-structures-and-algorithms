# 3392. Count Subarrays of Length Three With a Condition

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/

---

## Problem Statement

Given an integer array `nums`, return the number of subarrays of length 3 such that the sum of the first and third numbers equals exactly half of the second number.

---

## Examples

**Example 1:**
```
Input:  nums = [1,2,1,4,1]
Output: 1
```
Explanation: The subarray `[1,4,1]` satisfies the condition since `1 + 1 = 2 = 4 / 2`.

**Example 2:**
```
Input:  nums = [1,1,1]
Output: 0
```
Explanation: The only three-element subarray `[1,1,1]` does not satisfy the condition.

---

## Constraints

- `3 <= nums.length <= 100`
- `-100 <= nums[i] <= 100`
