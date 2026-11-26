# 2025. Maximum Number of Ways to Partition an Array

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-number-of-ways-to-partition-an-array/

---

## Problem Statement

Given a 0-indexed integer array `nums` and an integer `k`. You can choose to change `nums[j]` to `k` for at most one index `j`. A pivot index splits the array into two non-empty parts with equal sum. Return the maximum number of pivot indices after at most one operation.

---

## Examples

**Example 1:**
```
Input:  nums = [2,-1,2], k = 3
Output: 1
```

**Example 2:**
```
Input:  nums = [0,0,0], k = 1
Output: 3
```

**Example 3:**
```
Input:  nums = [22,4,-25,-20,-15,15,-16,7,19,-10,0,-13,-14], k = -33
Output: 4
```

---

## Constraints

- `n == nums.length`
- `2 <= n <= 10^5`
- `-10^5 <= nums[i], k <= 10^5`
