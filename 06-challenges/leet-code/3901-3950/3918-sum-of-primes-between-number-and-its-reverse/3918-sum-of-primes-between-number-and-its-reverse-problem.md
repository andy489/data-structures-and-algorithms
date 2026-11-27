# 3918. Sum of Primes Between Number and Its Reverse

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/sum-of-primes-between-number-and-its-reverse/

## Problem

You are given an integer `n`.

Let `r` be the integer formed by reversing the digits of `n`.

Return the **sum** of all **prime numbers** between `min(n, r)` and `max(n, r)`, inclusive.

## Examples

**Example 1:**
```
Input: n = 13
Output: 132

Explanation:
- Reverse of 13 is 31. Range is [13, 31].
- Primes in range: 13, 17, 19, 23, 29, 31.
- Sum = 13 + 17 + 19 + 23 + 29 + 31 = 132.
```

**Example 2:**
```
Input: n = 10
Output: 17

Explanation:
- Reverse of 10 is 01 = 1. Range is [1, 10].
- Primes: 2, 3, 5, 7. Sum = 17.
```

**Example 3:**
```
Input: n = 8
Output: 0

Explanation:
- Reverse of 8 is 8. Range is [8, 8]. No primes (8 is not prime).
```

## Constraints

- `1 <= n <= 1000`
