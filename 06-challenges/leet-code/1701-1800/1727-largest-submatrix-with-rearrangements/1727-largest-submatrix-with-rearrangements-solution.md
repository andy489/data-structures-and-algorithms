# 1727. Largest Submatrix with Rearrangements — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/largest-submatrix-with-rearrangements/

---

## Solution: Column Height Histogram + Sort — O(m · n log n) time, O(n) space

**Idea:** Compute the "consecutive 1s ending at row i" histogram for each column. For each row, sort the heights descending. For each position `j` (0-indexed) in the sorted array, the rectangle of height `heights[j]` and width `j+1` is achievable by picking the `j+1` tallest columns. Take the maximum.

**Algorithm:**
1. For each row `i` and column `j`: if `matrix[i][j] == 1`, set `matrix[i][j] = matrix[i-1][j] + 1` (in-place histogram).
2. For each row, sort the row's heights descending.
3. Update answer with `max(heights[j] * (j + 1))` for each `j`.

**Complexity:**

| | |
|---|---|
| Time | O(m · n log n) — sort per row |
| Space | O(n) — sorting is in-place on the row |
