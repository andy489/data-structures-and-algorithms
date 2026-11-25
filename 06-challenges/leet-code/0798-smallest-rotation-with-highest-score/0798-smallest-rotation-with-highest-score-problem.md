# 798. Smallest Rotation with Highest Score

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/smallest-rotation-with-highest-score/

---

## Problem Statement

You are given an array `nums`. We may rotate it by a non-negative integer `k` so that the array becomes `nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]`. Afterward, any entries that are less than or equal to their index are worth `1` point.

For example, if we have `nums = [2,4,1,3,0]`, and we rotate by `k = 2`, it becomes `[1,3,0,2,4]`. This is worth `3` points because `1 > 0`, `3 > 1`, `0 <= 2`.

Return the rotation index `k` (0 <= k < nums.length) that corresponds to the highest score. If there are multiple answers, return the smallest such index `k`.

---

## Examples

**Example 1:**
```
Input:  nums = [2,4,1,3,0]
Output: 3
```

**Example 2:**
```
Input:  nums = [1,3,0,2,4]
Output: 0
```

---

## Constraints

- `1 <= nums.length <= 10^5`
- `0 <= nums[i] < nums.length`
