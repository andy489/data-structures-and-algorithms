# 204. Count Primes — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-primes/

---

## Solution: Sieve of Eratosthenes — O(n log log n) time, O(n) space

**Idea:** Create a boolean array `isComposite` of size `n`, initially all `false`. For each number `i` starting from 2, if it is not yet marked composite, it is prime — mark all its multiples starting from `i*i` as composite. Count the entries still `false` at the end.

**Algorithm:**
1. If `n < 2`, return `0`.
2. Allocate `isComposite[0..n-1]`, all `false`.
3. For `i` from `2` to `√n`:
   - If `isComposite[i]` is `false`, mark `isComposite[i*i], isComposite[i*i+i], ...` as `true` (stop before `n`).
4. Count and return the number of indices `i` in `[2, n-1]` where `isComposite[i]` is `false`.

**Complexity:**

| | |
|---|---|
| Time | O(n log log n) — classic sieve complexity |
| Space | O(n) — boolean array of size n |
