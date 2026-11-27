# 1175. Prime Arrangements — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/prime-arrangements/

---

## Solution: Count Primes + Factorial — O(n√n) time, O(1) space

**Idea:** The number of valid permutations equals the number of ways to arrange primes in prime-indexed positions times the number of ways to arrange non-primes in non-prime positions. If there are `p` primes ≤ n and `q = n - p` non-primes, the answer is `p! × q! mod (10^9 + 7)`.

**Algorithm:**
1. Count primes up to `n` using trial division.
2. Compute `p! mod MOD` and `(n-p)! mod MOD`.
3. Return their product mod MOD.

**Complexity:**

| | |
|---|---|
| Time | O(n√n) — primality check for each number up to n |
| Space | O(1) — only counters and running product |
