# 220. Contains Duplicate III

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/contains-duplicate-iii/

---

## Problem Statement

You are given an integer array `nums` and two integers `indexDiff` and `valueDiff`.

Find a pair of indices `(i, j)` such that:

- `i != j`,
- `abs(i - j) <= indexDiff`,
- `abs(nums[i] - nums[j]) <= valueDiff`, and

return `true` if such pair exists or `false` otherwise.

---

## Examples

**Example 1:**
```
Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
Output: true
```

**Example 2:**
```
Input: nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
Output: false
```

---

## Constraints

- `2 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`
- `1 <= indexDiff <= nums.length`
- `0 <= valueDiff <= 10^9`
