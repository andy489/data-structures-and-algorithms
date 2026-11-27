# 793. Preimage Size of Factorial Zeroes Function

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function/

---

## Problem Statement

Let `f(x)` be the number of zeroes at the end of `x!`. Recall that `x! = 1 * 2 * 3 * ... * x` and by convention, `0! = 1`.

- For example, `f(3) = 0` because `3! = 6` has no zeroes and `f(11) = 2` because `11! = 39916800` has two zeroes.

Given an integer `k`, return the number of non-negative integers `x` such that `f(x) = k`.

---

## Examples

**Example 1:**
```
Input:  k = 0
Output: 5
Explanation: 0!, 1!, 2!, 3!, 4! all have 0 trailing zeroes.
```

**Example 2:**
```
Input:  k = 5
Output: 0
Explanation: There is no x such that x! has 5 trailing zeroes.
```

**Example 3:**
```
Input:  k = 3
Output: 5
```

---

## Constraints

- `0 <= k <= 10^9`
