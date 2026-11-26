# 766. Toeplitz Matrix — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/toeplitz-matrix/

---

## Solution: Check Each Cell Against Previous Diagonal — O(m·n) time, O(1) space

**Idea:** For every cell `(r, c)` where `r > 0` and `c > 0`, check if `matrix[r][c] == matrix[r-1][c-1]`. If any fails, return false.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — visit each cell once |
| Space | O(1) |
