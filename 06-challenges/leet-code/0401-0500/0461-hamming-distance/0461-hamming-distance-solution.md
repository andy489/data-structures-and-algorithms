# 461. Hamming Distance — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/hamming-distance/

---

## Solution: XOR + Bit Count — O(1) time, O(1) space

**Idea:** XOR of `x` and `y` has 1-bits exactly where they differ. Count the 1-bits.

**Algorithm:**
1. Compute `xor = x ^ y`.
2. Return `Integer.bitCount(xor)`.

**Complexity:**

| | |
|---|---|
| Time | O(1) — fixed 32-bit integers |
| Space | O(1) |
