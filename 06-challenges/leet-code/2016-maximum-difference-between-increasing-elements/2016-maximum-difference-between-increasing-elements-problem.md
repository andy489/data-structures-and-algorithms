# 2016. Maximum Difference Between Increasing Elements

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-difference-between-increasing-elements/

---

## Problem Statement

Given a 0-indexed integer array `nums`, find the **maximum difference** between `nums[j] - nums[i]` such that `0 <= i < j < n` and `nums[i] < nums[j]`. If no such pair exists, return `-1`.

---

## Examples

**Example 1:**
```
Input:  nums = [7,1,5,4]
Output: 4
```
Explanation: i=1,j=2: 5-1=4.

**Example 2:**
```
Input:  nums = [9,4,3,2]
Output: -1
```
Explanation: No increasing pair.

**Example 3:**
```
Input:  nums = [1,5,2,10]
Output: 9
```
Explanation: i=0,j=3: 10-1=9.

---

## Constraints

- `n == nums.length`
- `2 <= n <= 1000`
- `1 <= nums[i] <= 10^9`
