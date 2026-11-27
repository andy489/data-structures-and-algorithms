# 3095. Shortest Subarray With OR at Least K I

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-i/

---

## Problem Statement

You are given an array `nums` of non-negative integers and an integer `k`. An array is called special if the bitwise OR of all its elements is at least `k`. Return the length of the shortest special non-empty subarray of `nums`, or return `-1` if no special subarray exists.

---

## Examples

**Example 1:**
```
Input:  nums = [1,2,3], k = 2
Output: 1
```
Explanation: [3] has OR=3>=2.

**Example 2:**
```
Input:  nums = [2,1,8], k = 10
Output: 3
```

---

## Constraints

- `1 <= nums.length <= 50`
- `0 <= nums[i] <= 50`
- `0 <= k <= 50`
