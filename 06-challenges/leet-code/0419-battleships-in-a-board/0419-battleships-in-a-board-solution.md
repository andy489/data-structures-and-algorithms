# 419. Battleships in a Board — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/battleships-in-a-board/

---

## Solution: One-Pass O(1) Space — O(m·n) time, O(1) space

**Idea:** Count only the "head" cell of each battleship. A cell `(r, c)` is a head if it is `'X'` and neither `board[r-1][c]` nor `board[r][c-1]` is `'X'` (no preceding neighbour). This avoids modifying the board and uses no extra memory.

**Algorithm:**
1. Iterate over every cell.
2. If cell is `'X'`, check the cell above and the cell to the left; if both are not `'X'` (or don't exist), increment counter.
3. Return counter.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — single pass |
| Space | O(1) — only a counter |
