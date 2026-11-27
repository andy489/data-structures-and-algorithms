# 36. Valid Sudoku — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/valid-sudoku/

---

## Solution: Single-pass with index-encoded sets — O(1) time, O(1) space

**Idea:** Iterate every cell once. For each filled cell at `(r, c)` with digit `d`, check three constraints simultaneously using three arrays of bitmasks (one per row, column, and box). The box index is `(r / 3) * 3 + (c / 3)`. A digit `d` (1–9) maps to bit `1 << d`. If the corresponding bit is already set in any of the three masks, the board is invalid; otherwise set it.

**Algorithm:**
1. Allocate three `int[9]` bitmask arrays: `rows`, `cols`, `boxes`.
2. For each cell `(r, c)`: skip if `'.'`.
3. Compute `bit = 1 << (board[r][c] - '0')` and `box = (r / 3) * 3 + (c / 3)`.
4. If `rows[r] & bit`, `cols[c] & bit`, or `boxes[box] & bit` is non-zero → return `false`.
5. Otherwise OR each mask with `bit` and continue.
6. Return `true`.

**Complexity:**

| | |
|---|---|
| Time | O(1) — exactly 81 cells, fixed board size |
| Space | O(1) — three arrays of 9 integers, fixed size |
