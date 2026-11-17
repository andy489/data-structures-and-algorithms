# 51. N-Queens — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/n-queens/

---

## Solution 1: Backtracking with Sets — O(n!) time, O(n²) space

**Idea:**

Place queens one row at a time. For each row, try every column. A placement at `(row, col)` is valid if no previously placed queen shares the same column, the same forward diagonal (`row - col` is constant along `↗` diagonals), or the same backward diagonal (`row + col` is constant along `↘` diagonals). Maintain three hash sets to track occupied columns and diagonals, giving O(1) conflict checks.

When a complete placement is found (all `n` rows filled), convert the column array to a board representation and add it to the result.

**Algorithm:**
1. Maintain sets `cols`, `diag1` (values `row - col`), `diag2` (values `row + col`), and an array `queens[row] = col`.
2. Recurse row by row. For each column, if none of the three sets contains the conflict key, place the queen (add to all sets), recurse, then remove it (backtrack).
3. When `row == n`, build the board: for each row construct a string of `n` characters with `'Q'` at `queens[row]` and `'.'` elsewhere.

**Complexity:**

| | |
|---|---|
| Time | O(n!) — at most n choices in row 0, n-1 in row 1, etc. |
| Space | O(n²) — output boards; O(n) recursion depth + sets |

---

## Solution 2: Backtracking with Bitmasks — O(n!) time, O(n²) space

**Idea:**

Encode all three conflict constraints as bitmasks over `n` bits. At each row:
- `cols` — bitmask of occupied columns (bit `c` set if column `c` is taken).
- `diag1` — left diagonal mask, shifted right by 1 each row (`>> 1`) as diagonals move left going down.
- `diag2` — right diagonal mask, shifted left by 1 each row (`<< 1`) as diagonals move right going down.

The available columns for the current row are `~(cols | diag1 | diag2) & fullMask` where `fullMask = (1 << n) - 1`. Extract each candidate bit with `bit = available & -available` (isolates the lowest set bit), place the queen there, and recurse with updated masks. This avoids any hash-set overhead and keeps all conflict state in three integers.

**Algorithm:**
1. `fullMask = (1 << n) - 1`.
2. Recurse with `(row, cols, diag1, diag2, queens[])`.
3. `available = ~(cols | diag1 | diag2) & fullMask`.
4. While `available != 0`: extract `bit = available & -available`, set `queens[row] = bit.trailingZeros`, recurse with `(cols | bit, (diag1 | bit) >> 1, (diag2 | bit) << 1)`, then `available &= available - 1` to clear the bit.
5. At `row == n`, build and record the board.

**Complexity:**

| | |
|---|---|
| Time | O(n!) — same traversal as Solution 1 |
| Space | O(n²) — output; O(n) recursion depth, no sets |
