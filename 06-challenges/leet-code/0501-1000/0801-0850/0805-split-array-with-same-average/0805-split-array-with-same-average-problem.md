# 805. Split Array With Same Average

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/split-array-with-same-average/

---

## Problem Statement

You are given an integer array `nums`. You have to partition the array into two non-empty subsets `A` and `B` such that the average of `A` equals the average of `B`.

Return `true` if it is possible to partition `nums` into two parts with equal average, otherwise `false`.

---

## Examples

**Example 1:**
```
Input:  nums = [1,2,3,4,5,6,7,8]
Output: true
Explanation: We can split it into [1,4,5,8] and [2,3,6,7] both with average 4.5.
```

**Example 2:**
```
Input:  nums = [3,1]
Output: false
```

---

## Constraints

- `1 <= nums.length <= 30`
- `0 <= nums[i] <= 10^4`
