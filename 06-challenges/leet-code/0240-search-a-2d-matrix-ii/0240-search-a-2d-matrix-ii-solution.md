# 240. Search a 2D Matrix II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/search-a-2d-matrix-ii/

---

## Solution: Start at Top-Right — O(m+n) time, O(1) space

**Idea:** Start at the top-right corner. If the current value equals `target`, return true. If it is greater, eliminate the entire column by moving left. If it is smaller, eliminate the entire row by moving down.

**Algorithm:**
1. `r = 0`, `c = n - 1`.
2. While `r < m && c >= 0`: compare `matrix[r][c]` with `target`; if equal return `true`; if greater `c--`; else `r++`.
3. Return `false`.

**Complexity:**

| | |
|---|---|
| Time | O(m + n) — at most m+n steps |
| Space | O(1) |
