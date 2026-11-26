# 1252. Cells with Odd Values in a Matrix — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/

---

## Solution: Row/Column Parity — O(indices.length + m + n) time, O(m + n) space

**Idea:** Track parity of increments per row and column. A cell is odd iff row_parity[r] XOR col_parity[c] is 1.

**Algorithm:**
1. Count how many times each row and column is incremented (mod 2).
2. Count odd rows and odd columns.
3. Answer = odd_rows * (n - odd_cols) + (m - odd_rows) * odd_cols.

**Complexity:**

| | |
|---|---|
| Time | O(indices.length + m + n) |
| Space | O(m + n) |
