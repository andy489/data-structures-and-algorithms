# 902. Numbers At Most N Given Digit Set — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/numbers-at-most-n-given-digit-set/

---

## Solution: Digit DP / Math — O(log n * d) time, O(log n) space

**Idea:** Count numbers with fewer digits than n (all such are valid: d^1 + d^2 + ... + d^(L-1)), then count L-digit numbers ≤ n by scanning each position: count digits strictly less than n's digit at position i, multiply by d^(remaining), and check if n's digit is in the set.

**Algorithm:**
1. Convert n to string S of length L.
2. For lengths 1..L-1: add d^len (all combinations valid).
3. For length L: iterate position i. Count digits in `digits` < S[i], add count * d^(L-1-i). If S[i] not in digits, break. If reached end, add 1 (n itself counts).

**Complexity:**

| | |
|---|---|
| Time | O(log n × d) — L positions, d digits each |
| Space | O(log n) — string representation |
