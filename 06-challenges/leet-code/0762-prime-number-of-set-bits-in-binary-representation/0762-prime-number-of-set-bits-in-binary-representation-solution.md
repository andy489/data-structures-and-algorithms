# 762. Prime Number of Set Bits in Binary Representation — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/

---

## Solution: Bit Count + Prime Check — O(n log max) time, O(1) space

**Idea:** Since numbers ≤ 10^6 have at most 20 bits, primes to check are small: {2,3,5,7,11,13,17,19}. For each number, count set bits and check if that count is prime using the precomputed set.

**Algorithm:**
1. Precompute prime set = {2,3,5,7,11,13,17,19}.
2. For each `n` in `[left, right]`: count bits (Integer.bitCount), check if in prime set.
3. Sum the matches.

**Complexity:**

| | |
|---|---|
| Time | O(n) — n = right - left + 1 |
| Space | O(1) |
