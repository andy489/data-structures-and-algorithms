# 1099. Two Sum Less Than K

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/two-sum-less-than-k/

---

## Problem Statement

Given an array `nums` of integers and integer `k`, return the maximum `S` such that there exists `i < j` with `nums[i] + nums[j] = S` and `S < k`. If no such `i`, `j` exist satisfying this equation, return `-1`.

---

## Examples

**Example 1:**
```
Input:  nums = [34,23,1,24,75,33,54,8], k = 60
Output: 58
```

**Example 2:**
```
Input:  nums = [10,20,30], k = 15
Output: -1
```

---

## Constraints

- `1 <= nums.length <= 100`
- `1 <= nums[i] <= 1000`
- `1 <= k <= 2000`
