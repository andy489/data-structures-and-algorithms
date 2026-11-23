# 479. Largest Palindrome Product — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/largest-palindrome-product/

---

## Solution: Enumerate Upper Halves — O(10^n) time, O(1) space

**Idea:** A palindrome of 2n digits has the form `upper | reverse(upper)`. Enumerate `upper` from `10^n - 1` down to `10^(n-1)`. For each upper, form the palindrome and check if it has two n-digit factors.

**Algorithm:**
1. Special case: n=1 → return 9.
2. For upper from max n-digit to min:
   - Build palindrome = `upper * 10^n + reverse(upper)`.
   - Check divisors from `10^n - 1` down; if `palindrome % divisor == 0` and quotient is n-digit, return `palindrome % 1337`.

**Complexity:**

| | |
|---|---|
| Time | O(10^n) — at most 10^n upper values, each checked in O(10^(n/2)) |
| Space | O(1) |
