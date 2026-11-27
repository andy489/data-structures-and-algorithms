# 717. 1-bit and 2-bit Characters — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/1-bit-and-2-bit-characters/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** Walk through bits with an index. If current bit is `1`, it starts a 2-bit character, skip 2. If `0`, it's a 1-bit character, skip 1. The last character is 1-bit if we land exactly on the last index.

**Algorithm:**
1. Set `i = 0`. Loop while `i < bits.length - 1`:
   - If `bits[i] == 1`, advance `i` by 2.
   - Else advance `i` by 1.
2. Return `i == bits.length - 1`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
