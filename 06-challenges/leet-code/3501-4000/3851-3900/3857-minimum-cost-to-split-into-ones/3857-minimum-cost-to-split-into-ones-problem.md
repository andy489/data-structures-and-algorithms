# 3857. Minimum Cost to Split into Ones

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/minimum-cost-to-split-into-ones/

## Problem

You are given an integer `n`.

In one operation, you may split an integer `x` into two positive integers `a` and `b` such that `a + b = x`.

The cost of this operation is `a * b`.

Return an integer denoting the minimum total cost required to split the integer `n` into `n` ones.

## Examples

**Example 1:**
```
Input: n = 3
Output: 3
Explanation:
- Split 3 into 1 + 2, cost = 2.
- Split 2 into 1 + 1, cost = 1.
Total = 3.
```

**Example 2:**
```
Input: n = 4
Output: 6
Explanation:
- Split 4 into 2 + 2, cost = 4.
- Split 2 into 1 + 1, cost = 1 (twice).
Total = 4 + 1 + 1 = 6.
```

## Constraints

- `1 <= n <= 500`
