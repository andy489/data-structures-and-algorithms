# 18. 4Sum

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/4sum/

---

## Problem Statement

Given an integer array `nums` and an integer `target`, return all the quadruplets `[nums[a], nums[b], nums[c], nums[d]]` such that `a`, `b`, `c`, `d` are distinct indices and `nums[a] + nums[b] + nums[c] + nums[d] == target`.

The solution set must **not contain duplicate quadruplets**.

---

## Examples

**Example 1:**
```
Input:  nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
```

**Example 2:**
```
Input:  nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
```

---

## Constraints

- `1 <= nums.length <= 200`
- `-10^9 <= nums[i] <= 10^9`
- `-10^9 <= target <= 10^9`
