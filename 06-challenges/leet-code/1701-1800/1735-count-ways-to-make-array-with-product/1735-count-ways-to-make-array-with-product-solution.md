# 1735. Count Ways to Make Array with Product — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-ways-to-make-array-with-product/

---

## Solution: Prime Factorization + Stars-and-Bars — O(Q · sqrt(k) · log(n)) time, O(1) extra

**Idea:** The number of ways to place `k` as a product across `n` slots equals the product over each prime factor `p^e` of `k` of `C(n + e - 1, e)` (stars-and-bars: distribute `e` identical items into `n` bins). This follows because prime factors are independent.

**Algorithm:**
1. Precompute factorials and inverse factorials for combination computation mod `10^9 + 7`.
2. For each query `[n, k]`:
   a. Factorize `k` into prime powers `p^e`.
   b. Multiply answer by `C(n + e - 1, e)` for each prime factor.
3. `C(n + e - 1, e) = (n+e-1)! / (e! * (n-1)!)` computed with precomputed inverses.

**Complexity:**

| | |
|---|---|
| Time | O(Q · sqrt(k)) — factorization per query |
| Space | O(N + K) — factorial arrays |
