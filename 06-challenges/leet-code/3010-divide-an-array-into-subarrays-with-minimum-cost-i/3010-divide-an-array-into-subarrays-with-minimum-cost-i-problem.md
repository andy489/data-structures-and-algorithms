# 3010. Divide an Array Into Subarrays With Minimum Cost I

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/

---

## Problem Statement

You are given an array of integers `nums` with length `n`.

The cost of an array is the value of its first element. For example, the cost of `[1,2,3]` is `1`.

You need to divide `nums` into 3 contiguous subarrays.

Return the minimum possible sum of the cost of these subarrays.

---

## Examples

**Example 1:**
```
Input:  nums = [1,2,3,12]
Output: 6
```
Explanation: Divide as [1],[2],[3,12]. Costs: 1+2+3=6.

**Example 2:**
```
Input:  nums = [5,4,3]
Output: 12
```
Explanation: Only way: [5],[4],[3]. Cost=12.

---

## Constraints

- `3 <= n <= 50`
- `1 <= nums[i] <= 50`
