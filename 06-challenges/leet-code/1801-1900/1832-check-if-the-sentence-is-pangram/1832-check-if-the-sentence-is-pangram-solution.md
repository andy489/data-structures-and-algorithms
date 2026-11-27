# 1832. Check if the Sentence Is Pangram — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/check-if-the-sentence-is-pangram/

---

## Solution: Bit Mask — O(n) time, O(1) space

**Idea:** Use a 26-bit integer as a bitmask. For each character, set the corresponding bit. After processing the entire string, check if all 26 bits are set (mask == (1 << 26) - 1).

**Algorithm:**
1. Initialize `mask = 0`.
2. For each character `c` in `sentence`: set bit `c - 'a'` in `mask`.
3. Return `mask == (1 << 26) - 1`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass over the string |
| Space | O(1) — single integer bitmask |
