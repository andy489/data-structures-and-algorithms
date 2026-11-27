# 962. Maximum Width Ramp

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-width-ramp/

---

## Problem Statement

A ramp in an integer array `nums` is a pair `(i, j)` for which `i < j` and `nums[i] <= nums[j]`. The width of such a ramp is `j - i`.

Given an integer array `nums`, return the maximum width of a ramp in `nums`. If there is no ramp in `nums`, return `0`.

---

## Examples

**Example 1:**
```
Input:  nums = [6,0,8,2,1,5]
Output: 4
```

**Example 2:**
```
Input:  nums = [9,8,1,0,1,9,4,0,4,1]
Output: 7
```

---

## Constraints

- `2 <= nums.length <= 5 * 10^4`
- `0 <= nums[i] <= 5 * 10^4`
