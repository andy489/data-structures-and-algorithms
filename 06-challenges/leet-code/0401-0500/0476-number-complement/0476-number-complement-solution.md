# 476. Number Complement — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/number-complement/

---

## Solution: Bit Mask — O(1) time, O(1) space

**Idea:** Create a mask of all 1s with the same bit-length as `num`, then XOR with `num` to flip all bits.

**Algorithm:**
1. Find the highest set bit position.
2. Mask = `(1 << bitLength) - 1`.
3. Return `num XOR mask`.

**Complexity:**

| | |
|---|---|
| Time | O(1) — fixed 32-bit integer operations |
| Space | O(1) |
