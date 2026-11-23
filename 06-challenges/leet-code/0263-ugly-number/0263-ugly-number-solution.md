# 263. Ugly Number — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/ugly-number/

---

## Solution: Repeated Division — O(log n) time, O(1) space

**Idea:** Divide out all factors of 2, 3, and 5. If the result is 1, only those primes divided in, so it's ugly. If the result is anything other than 1, it had another prime factor.

**Algorithm:**
1. If `n <= 0`, return `false`.
2. For each of `{2, 3, 5}`, divide `n` by that factor while divisible.
3. Return `n == 1`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — number of divisions is logarithmic |
| Space | O(1) — no extra space |
