# 2006. Count Number of Pairs With Absolute Difference K

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/

---

## Problem Statement

Given an integer array `nums` and an integer `k`, return the number of pairs `(i, j)` where `i < j` such that `|nums[i] - nums[j]| == k`.

---

## Examples

**Example 1:**
```
Input:  nums = [1,2,2,1], k = 1
Output: 4
```
Explanation: Pairs: (0,1),(0,2),(1,3),(2,3).

**Example 2:**
```
Input:  nums = [1,3], k = 3
Output: 0
```

**Example 3:**
```
Input:  nums = [3,2,1,5,4], k = 2
Output: 3
```
Explanation: Pairs: (0,2),(0,4),(1,3).

---

## Constraints

- `1 <= nums.length <= 200`
- `1 <= nums[i] <= 100`
- `1 <= k <= 99`
