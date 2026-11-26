# 1001. Grid Illumination — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/grid-illumination/

---

## Solution: Hash Maps for Rows/Cols/Diagonals — O((L+Q)·9) time, O(L) space

**Idea:** Track illumination counts per row, column, main diagonal (r-c), and anti-diagonal (r+c). For each query, check if any count is nonzero, then decrement counts for the lamp and its 8 neighbors.

**Algorithm:**
1. Build four count maps: `row`, `col`, `diag` (r−c), `anti` (r+c), plus a set of lit lamp positions.
2. For each query (r, c): answer 1 if any of `row[r]`, `col[c]`, `diag[r-c]`, `anti[r+c]` > 0.
3. For each of the 9 neighbors (including (r,c)), if the lamp is on, decrement all four maps and remove from set.

**Complexity:**

| | |
|---|---|
| Time | O(L + Q·9) — L lamps + Q queries each checking 9 neighbors |
| Space | O(L) — four count maps |
