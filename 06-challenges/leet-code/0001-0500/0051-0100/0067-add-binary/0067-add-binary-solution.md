# 67. Add Binary — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/add-binary/

---

## Solution: Right-to-left scan with carry — O(n) time, O(n) space

**Idea:** Simulate binary addition from the least significant bit. Walk both strings from right to left, summing corresponding digits plus a carry bit. Append each result bit to a builder, then reverse at the end.

**Algorithm:**
1. Set pointers `i = a.length - 1`, `j = b.length - 1`, `carry = 0`.
2. While `i >= 0`, `j >= 0`, or `carry != 0`:
   - Add `carry` plus digit at `a[i]` (if valid) plus digit at `b[j]` (if valid).
   - Append `sum % 2` to the result buffer; set `carry = sum / 2`.
   - Decrement `i` and `j`.
3. Reverse the buffer and return it as a string.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass over both strings, where n = max(a.length, b.length) |
| Space | O(n) — result buffer of length n + 1 at most |
