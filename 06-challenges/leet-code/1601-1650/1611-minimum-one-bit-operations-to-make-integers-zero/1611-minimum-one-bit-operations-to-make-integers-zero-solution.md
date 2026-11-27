# 1611. Minimum One Bit Operations to Make Integers Zero — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/

---

## Solution: Gray Code — O(log n) time, O(1) space

**Idea:** The allowed operations are exactly the transitions in a Gray code. The number of operations to reduce `n` to `0` equals the position of `n` in the standard binary Gray code sequence, which is the Gray code rank (inverse Gray code) of `n`.

The inverse Gray code (Gray to binary conversion) is computed as:
`rank(n) = n XOR (n >> 1) XOR (n >> 2) XOR ...` until all bits are exhausted.

**Algorithm:**
1. Initialize `result = 0`.
2. While `n > 0`: `result ^= n`, then `n >>= 1`.
3. Return `result`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — number of bits in n |
| Space | O(1) — constant extra variables |
