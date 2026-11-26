# 2059. Minimum Operations to Convert Number

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-operations-to-convert-number/

---

## Problem Statement

You are given a 0-indexed integer array `nums` and two integers `start` and `goal`. In one operation, pick any element `nums[i]` and either add, subtract, or XOR it with current value. Value must stay in [0, 1000] except goal can be outside. Return minimum operations to reach `goal`.

---

## Examples

**Example 1:**
```
Input:  nums = [2,4,12], start = 2, goal = 12
Output: 2
```
Explanation: 2 XOR 2 = 0, 0+12=12.

**Example 2:**
```
Input:  nums = [3,5,7], start = 0, goal = -4
Output: 2
```
Explanation: 0+3=3, 3-7=-4.

**Example 3:**
```
Input:  nums = [2,8,16], start = 0, goal = 1
Output: -1
```

---

## Constraints

- ` 1 <= nums.length <= 1000`
- `−10^9 <= nums[i] <= 10^9`
- `0 <= start, goal <= 1000`
