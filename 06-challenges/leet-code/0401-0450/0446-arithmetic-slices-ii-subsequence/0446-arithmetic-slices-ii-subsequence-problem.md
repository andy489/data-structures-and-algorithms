# 446. Arithmetic Slices II - Subsequence

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/arithmetic-slices-ii-subsequence/

---

## Problem Statement

Given an integer array `nums`, return the number of all the **arithmetic subsequences** of `nums`.

A sequence of numbers is called **arithmetic** if it consists of **at least three** elements and if the difference between any two consecutive elements is the same.

---

## Examples

**Example 1:**
```
Input:  nums = [2,4,6,8,10]
Output: 7
Explanation: All arithmetic subsequences are:
[2,4,6], [4,6,8], [6,8,10], [2,4,6,8], [4,6,8,10], [2,4,6,8,10], [2,6,10]
```

**Example 2:**
```
Input:  nums = [7,7,7,7,7]
Output: 16
Explanation: Any subsequence of this array is arithmetic.
```

---

## Constraints

- `1 <= nums.length <= 1000`
- `-2^31 <= nums[i] <= 2^31 - 1`
