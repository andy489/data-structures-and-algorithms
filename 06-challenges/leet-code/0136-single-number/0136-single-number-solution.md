# 136. Single Number — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/single-number/

---

## Solution: XOR Bit Trick — O(n) time, O(1) space

**Idea:** XOR has two key properties: `a ^ a = 0` (a number XORed with itself cancels to zero) and `a ^ 0 = a` (XOR with zero is identity). XORing all elements together causes every duplicate pair to cancel out, leaving only the single number.

**Algorithm:**
1. Initialise `result = 0`.
2. For each `num` in `nums`: `result ^= num`.
3. Return `result`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass through the array |
| Space | O(1) — only one integer variable |
