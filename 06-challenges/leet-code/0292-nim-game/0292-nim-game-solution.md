# 292. Nim Game — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/nim-game/

---

## Solution: Math — O(1) time, O(1) space

**Idea:** You lose only when `n` is a multiple of 4. If `n % 4 == 0`, whatever you take (1, 2, or 3), your opponent can always take `4 - x` to leave you at the next multiple of 4. Any other value: you can reduce to the previous multiple of 4, forcing your opponent into the losing position.

**Algorithm:**
1. Return `n % 4 != 0`.

**Complexity:**

| | |
|---|---|
| Time | O(1) — single modulo |
| Space | O(1) — no extra space |
