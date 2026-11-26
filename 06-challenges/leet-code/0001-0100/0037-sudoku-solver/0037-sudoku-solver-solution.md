# 37. Sudoku Solver — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/sudoku-solver/

---

## Solution: Backtracking with bitmask constraint sets — O(1) time, O(1) space

**Idea:** Use three arrays of bitmasks (`rows`, `cols`, `boxes`) to track which digits are already placed — same encoding as problem 36. Scan left-to-right, top-to-bottom for the next empty cell, try each digit `1-9` that doesn't conflict, place it, recurse, and undo if the recursive call fails (backtrack).

**Algorithm:**
1. Build `rows[9]`, `cols[9]`, `boxes[9]` bitmasks from the pre-filled cells.
2. Call `solve(board, 0)` starting at position 0 (flattened index `r*9+c`).
3. At each position: if filled, advance to `pos+1`; if empty, iterate `d = 1..9`:
   - Compute `bit = 1 << d` and `box = (r/3)*3 + (c/3)`.
   - If `bit` conflicts with any mask, skip.
   - Otherwise place `d`, set the masks, recurse.
   - If recursion returns `true`, propagate `true` up.
   - Otherwise undo: restore `'.'` and clear the masks.
4. Return `true` when `pos == 81` (all cells filled).

**Complexity:**

| | |
|---|---|
| Time | O(1) — board is always 9×9; at most 9^81 states but heavily pruned |
| Space | O(1) — bitmask arrays are fixed size; recursion depth ≤ 81 |

---

## Solution 2: Backtracking without bitmasks (validity check per step) — O(1) time, O(1) space

**Idea:** Skip the upfront bitmask construction. For each candidate digit, call an `isValid` helper that scans the row, column, and box. Simpler code at the cost of more scanning per placement.

**Complexity:**

| | |
|---|---|
| Time | O(1) — same 9×9 bound; inner `isValid` scans at most 27 cells |
| Space | O(1) — no auxiliary structures beyond recursion stack |
