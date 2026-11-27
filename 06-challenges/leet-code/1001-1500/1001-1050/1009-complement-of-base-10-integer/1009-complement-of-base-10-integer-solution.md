# 1009. Complement of Base 10 Integer — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/complement-of-base-10-integer/

---

## Solution: Bit Mask — O(log n) time, O(1) space

**Idea:** XOR n with a mask of all 1s of the same bit-length as n. Special case: n=0 → return 1.

**Algorithm:**
1. Find bit length L of n.
2. mask = (1 << L) - 1.
3. Return n XOR mask.

**Complexity:**

| | |
|---|---|
| Time | O(log n) |
| Space | O(1) |
