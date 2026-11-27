# 3932. Count K-th Roots in a Range

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/count-k-th-roots-in-a-range/

## Problem

You are given three integers `l`, `r`, and `k`.

An integer `y` is said to be a **perfect k-th power** if there exists an integer `x` such that `y = x^k`.

Return the number of integers `y` in the range `[l, r]` (inclusive) that are **perfect k-th powers**.

## Examples

**Example 1:**

```
Input: l = 1, r = 9, k = 3
Output: 2
Explanation: Perfect cubes in [1, 9]: 1 = 1^3, 8 = 2^3.
```

**Example 2:**

```
Input: l = 8, r = 30, k = 2
Output: 3
Explanation: Perfect squares in [8, 30]: 9 = 3^2, 16 = 4^2, 25 = 5^2.
```

## Constraints

- `0 <= l <= r <= 10^9`
- `1 <= k <= 30`
