# 260. Single Number III — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/single-number-iii/

---

## Solution: Bit Manipulation (XOR + partition) — O(n) time, O(1) space

**Idea:** XOR all numbers to get `a ^ b` (the XOR of the two unique numbers). Since `a != b`, at least one bit differs — use the lowest set bit of `a ^ b` as a mask to partition all numbers into two groups: one group XORs to `a`, the other to `b`.

**Algorithm:**
1. XOR all elements: `xor = a ^ b`.
2. Find the lowest set bit: `mask = xor & (-xor)`.
3. Partition elements by whether `(num & mask) != 0`. XOR each group separately to recover `a` and `b`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two linear passes |
| Space | O(1) — only a few variables |
