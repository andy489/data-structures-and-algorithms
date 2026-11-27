# 1808. Maximize Number of Nice Divisors

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximize-number-of-nice-divisors/

---

## Problem Statement

You are given a positive integer `primeFactors`. You are asked to construct a positive integer `n` that satisfies the following conditions:

- The number of prime factors of `n` (not necessarily distinct) is **at most** `primeFactors`.
- The number of **nice divisors** of `n` is **maximized**.

A divisor of `n` is **nice** if it is divisible by every prime factor of `n`.

Return the number of nice divisors of `n`. Since that number can be huge, return it **modulo** `10^9 + 7`.

Note that a prime number `p` is a prime factor of `n` if and only if `n` is divisible by `p`.

---

## Examples

**Example 1:**
```
Input: primeFactors = 5
Output: 6
Explanation: 12 = 2^2 * 3 has primeFactors = 3 and nice divisors = {12} → wait.
Actually: n = 2^2 * 3 has 2 prime factors (2 and 3), 2+1 = 3 total primes used (2*2 is 2^2).
Best split of 5 prime factors: use groups of sizes [2, 3] → 2 * 3 = 6.
```

**Example 2:**
```
Input: primeFactors = 8
Output: 18
Explanation: Best split: [3, 3, 2] → 3 * 3 * 2 = 18.
```

---

## Constraints

- `1 <= primeFactors <= 10^9`
