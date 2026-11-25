# 1004. Max Consecutive Ones III

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/max-consecutive-ones-iii/

---

## Problem Statement

Given a binary array `nums` and an integer `k`, return the maximum number of consecutive `1`'s in the array if you can flip at most `k` `0`'s.

---

## Examples

**Example 1:**
```
Input:  nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
```

**Example 2:**
```
Input:  nums = [0,0,1,1,0,0,1,1,1,0,1,1,1,1,1,0,0,0,0,0,0], k = 3
Output: 10
```

---

## Constraints

- `1 <= nums.length <= 10^5`
- `nums[i]` is either `0` or `1`.
- `0 <= k <= nums.length`
