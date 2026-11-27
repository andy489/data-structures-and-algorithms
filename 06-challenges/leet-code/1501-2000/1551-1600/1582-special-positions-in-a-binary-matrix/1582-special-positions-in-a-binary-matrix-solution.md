# 1582. Special Positions in a Binary Matrix — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/special-positions-in-a-binary-matrix/

---

## Solution: Row and Column Sum — O(m*n) time, O(m+n) space

**Idea:** Precompute row and column sums. A position `(i, j)` is special if `mat[i][j] == 1`, its row sum is 1, and its column sum is 1.

**Algorithm:**
1. Compute `rowSum[i]` and `colSum[j]` for all rows and columns.
2. Count positions where `mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1`.

**Complexity:**

| | |
|---|---|
| Time | O(m*n) — two passes over the matrix |
| Space | O(m+n) — row and column sum arrays |
