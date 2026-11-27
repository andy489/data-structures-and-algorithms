# 52. N-Queens II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/n-queens-ii/

---

## Solution 1: Backtracking with Bitmasks — O(n!) time, O(n) space

**Idea:**

Same bitmask backtracking as [problem 51](../0051-n-queens/0051-n-queens-solution.md), but since we only need the count we skip board construction entirely. Three integers encode all conflict constraints:

- `cols` — occupied columns (bit `c` set if column `c` is taken).
- `diag1` — left-diagonal occupancy, shifted right by 1 each row.
- `diag2` — right-diagonal occupancy, shifted left by 1 each row.

Available columns for a row: `~(cols | diag1 | diag2) & fullMask`. Iterate over each set bit with `bit = available & -available`, recurse with updated masks, then clear the bit (`available &= available - 1`). Increment a counter when `row == n`.

Because no board is stored the space drops to O(n) (recursion depth only).

**Algorithm:**
1. `fullMask = (1 << n) - 1`.
2. Recurse `(row, cols, diag1, diag2)` starting from `(0, 0, 0, 0)`.
3. Base case `row == n`: return 1.
4. Accumulate `bit = available & -available` over `available = ~(cols | diag1 | diag2) & fullMask`.
5. Each bit contributes `recurse(row+1, cols|bit, (diag1|bit)>>1, (diag2|bit)<<1)`.

**Complexity:**

| | |
|---|---|
| Time | O(n!) — same traversal as N-Queens |
| Space | O(n) — recursion depth only; no board storage |

---

## Solution 2: Backtracking with Sets — O(n!) time, O(n) space

**Idea:** Same three-set conflict tracking as [problem 51](../0051-n-queens/0051-n-queens-solution.md) Solution 1, counting valid placements instead of recording boards. Cleaner to read; slightly higher constant than the bitmask version due to hash-set operations.

**Algorithm:**
1. Maintain sets `cols`, `diag1` (`row - col`), `diag2` (`row + col`).
2. Recurse row by row; for each valid column, add to sets, recurse, remove.
3. Increment counter at `row == n`.

**Complexity:**

| | |
|---|---|
| Time | O(n!) |
| Space | O(n) — sets hold at most n elements; O(n) recursion depth |
