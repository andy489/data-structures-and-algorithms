# 782. Transform to Chessboard — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/transform-to-chessboard/

---

## Solution: Bit Manipulation — O(n²) time, O(1) space

**Idea:** A valid chessboard has at most 2 distinct rows and 2 distinct columns (each is the bitwise NOT of the other). Check validity conditions, then count mismatches in rows and columns independently.

**Algorithm:**
1. For validity: each row XORed with row 0 must be all-0 or all-1 (complement). Same for columns.
2. Count ones in row 0 and column 0: must be `n/2` or `ceil(n/2)`.
3. Count mismatches between actual first row/col and the two target patterns; take the minimum.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — scan all cells |
| Space | O(1) |
