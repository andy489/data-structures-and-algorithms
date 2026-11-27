# 1632. Rank Transform of a Matrix — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/rank-transform-of-a-matrix/

---

## Solution: Sort + Union-Find by Value — O(m * n * log(m * n) * α(m + n)) time, O(m * n) space

**Idea:** Process cells in sorted order by value. For cells with the same value, they may be in the same row or column, meaning they must receive the same rank. Union-Find groups such cells together. Each group's rank is determined by the maximum rank currently assigned to any row or column in that group plus one.

**Algorithm:**
1. Group all cells by their value and sort the groups by value.
2. For each group of equal-valued cells:
   a. Build a temporary Union-Find among the cells sharing a row or column.
   b. For each connected component, find the maximum rank among all rows and columns touched.
   c. Assign `maxRank + 1` to all cells in the component; update row and column rank trackers.
3. Return the result matrix.

**Complexity:**

| | |
|---|---|
| Time | O(m * n * log(m * n) * α(m + n)) — sort + UF per group |
| Space | O(m * n) — grouping, UF, and answer matrix |
