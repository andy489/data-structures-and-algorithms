# 1646. Get Maximum in Generated Array

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/get-maximum-in-generated-array/

---

## Problem Statement

You are given an integer `n`. A **0-indexed** integer array `nums` of length `n + 1` is generated in the following way:

- `nums[0] = 0`
- `nums[1] = 1`
- `nums[2 * i] = nums[i]` when `2 <= 2 * i <= n`
- `nums[2 * i + 1] = nums[i] + nums[i + 1]` when `2 <= 2 * i + 1 <= n`

Return the **maximum** integer in the array `nums`.

---

## Examples

**Example 1:**
```
Input: n = 7
Output: 3
Explanation: According to the rules: nums = [0,1,1,2,1,3,2,3]. Maximum is 3.
```

**Example 2:**
```
Input: n = 2
Output: 1
Explanation: nums = [0,1,1]. Maximum is 1.
```

**Example 3:**
```
Input: n = 3
Output: 2
Explanation: nums = [0,1,1,2]. Maximum is 2.
```

---

## Constraints

- `0 <= n <= 100`
