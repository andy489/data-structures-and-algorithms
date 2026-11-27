# 693. Binary Number with Alternating Bits — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/binary-number-with-alternating-bits/

---

## Solution: Bit Trick — O(1) time, O(1) space

**Idea:** If n has alternating bits, then `n ^ (n >> 1)` should be all 1s (i.e., of the form `2^k - 1`). Check with `x & (x+1) == 0`.

**Algorithm:**
1. `x = n ^ (n >> 1)`.
2. Return `(x & (x+1)) == 0`.

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |
