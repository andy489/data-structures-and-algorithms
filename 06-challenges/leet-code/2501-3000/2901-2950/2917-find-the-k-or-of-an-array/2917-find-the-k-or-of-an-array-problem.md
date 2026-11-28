# 2917. Find the K-or of an Array

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-the-k-or-of-an-array/

---

## Problem Statement

You are given an integer array `nums`, and an integer `k`. The **K-or** operation extends the standard bitwise OR: a bit position in the result is set to `1` if at least `k` numbers in `nums` have a `1` in that position.

Return the K-or of `nums`.

---

## Examples

**Example 1:**
```
Input: nums = [7,12,9,8,9,15], k = 4
Output: 9
Explanation: Bit 0 appears in 4 numbers, bit 3 appears in 5 numbers. Result = 1001 = 9.
```

**Example 2:**
```
Input: nums = [2,12,1,11,4,5], k = 6
Output: 0
Explanation: No bit appears as 1 in all 6 numbers.
```

**Example 3:**
```
Input: nums = [10,8,5,9,11,6,8], k = 1
Output: 15
```

---

## Constraints

- `1 <= nums.length <= 50`
- `0 <= nums[i] < 2^31`
- `1 <= k <= nums.length`
