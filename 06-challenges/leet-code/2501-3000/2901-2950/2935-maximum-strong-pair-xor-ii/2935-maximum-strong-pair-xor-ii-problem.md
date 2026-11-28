# 2935. Maximum Strong Pair XOR II

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-strong-pair-xor-ii/

---

## Problem Statement

You are given a **0-indexed** integer array `nums`. A pair of integers `x` and `y` is called a **strong** pair if it satisfies the condition:

- `|x - y| <= min(x, y)`

You need to select two integers from `nums` such that they form a strong pair and their bitwise `XOR` is the **maximum** among all strong pairs in the array.

Return the **maximum** `XOR` value out of all possible strong pairs in the array `nums`.

**Note** that you can pick the same integer twice to form a pair.

---

## Examples

**Example 1:**
```
Input: nums = [1,2,3,4,5]
Output: 7
Explanation: The maximum XOR possible from these pairs is 3 XOR 4 = 7.
```

**Example 2:**
```
Input: nums = [10,100]
Output: 0
Explanation: The maximum XOR possible from these pairs is 10 XOR 10 = 0.
```

**Example 3:**
```
Input: nums = [500,520,2500,3000]
Output: 1020
Explanation: The maximum XOR possible from these pairs is 500 XOR 520 = 1020.
```

---

## Constraints

- `1 <= nums.length <= 5 * 10^4`
- `1 <= nums[i] <= 2^20 - 1`
