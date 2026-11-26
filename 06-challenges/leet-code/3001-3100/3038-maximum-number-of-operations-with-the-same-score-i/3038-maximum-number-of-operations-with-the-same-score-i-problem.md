# 3038. Maximum Number of Operations With the Same Score I

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-i/

---

## Problem Statement

Given an array of integers `nums`, in each operation you remove the first two elements of `nums` and their sum is the score. You can perform an operation only if the score equals the score of the first operation. Return the maximum number of operations.

---

## Examples

**Example 1:**
```
Input:  nums = [3,2,1,4,5]
Output: 2
```
Explanation: First score = 3+2=5. Second: 1+4=5. Third: 5 alone, can't. Answer=2.

**Example 2:**
```
Input:  nums = [1,5,3,3,4,1,3,2,2,3]
Output: 2
```

---

## Constraints

- `2 <= nums.length <= 2000`
- `1 <= nums[i] <= 1000`
