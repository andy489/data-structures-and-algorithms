# 73. Set Matrix Zeroes — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/set-matrix-zeroes/

---

## Solution: O(m+n) Space — O(m·n) time, O(m+n) space

**Idea:** Collect all row and column indices that contain a zero, then zero out those rows and columns in a second pass.

**Algorithm:**
1. Scan the matrix; add `i` to `zeroRows` set and `j` to `zeroCols` set whenever `matrix[i][j] == 0`.
2. For every `i` in `zeroRows`, set all elements in row `i` to `0`.
3. For every `j` in `zeroCols`, set all elements in column `j` to `0`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — two passes over the matrix |
| Space | O(m+n) — row and column index sets |

---

## Solution 2: Constant Space — O(m·n) time, O(1) space

**Idea:** Use the first row and first column of the matrix itself as markers. Before doing so, record whether the first row and first column originally contained any zero (since their markers would be overwritten).

**Algorithm:**
1. Check if column 0 has any zero → `firstColZero`.
2. Check if row 0 has any zero → `firstRowZero`.
3. For `i` from `1` to `m-1`, `j` from `1` to `n-1`: if `matrix[i][j] == 0`, set `matrix[i][0] = 0` and `matrix[0][j] = 0`.
4. For `i` from `1` to `m-1`: if `matrix[i][0] == 0`, zero out row `i`.
5. For `j` from `1` to `n-1`: if `matrix[0][j] == 0`, zero out column `j`.
6. If `firstRowZero`, zero out row 0.
7. If `firstColZero`, zero out column 0.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — constant number of passes |
| Space | O(1) — two boolean flags only |
