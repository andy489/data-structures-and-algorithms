# 1605. Find Valid Matrix Given Row and Column Sums — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/

---

## Solution: Greedy — O(m*n) time, O(m*n) space

**Idea:** At each cell `(i, j)`, greedily place the minimum of the remaining row sum and column sum. This ensures both the current row and column constraints are always satisfiable by the remaining cells.

**Algorithm:**
1. For each cell `(i, j)` in row-major order:
   - Set `matrix[i][j] = min(rowSum[i], colSum[j])`.
   - Subtract the placed value from both `rowSum[i]` and `colSum[j]`.
2. Return the matrix.

**Complexity:**

| | |
|---|---|
| Time | O(m*n) — visit each cell once |
| Space | O(m*n) — the output matrix |
