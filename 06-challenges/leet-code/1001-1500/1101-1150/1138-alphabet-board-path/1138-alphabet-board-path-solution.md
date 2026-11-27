# 1138. Alphabet Board Path — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/alphabet-board-path/

---

## Solution: Greedy Step-by-Step Navigation — O(n) time, O(n) space

**Idea:** Each character `c` maps to row `r = (c-'a') / 5` and column `col = (c-'a') % 5`. From the current position, we need to move to `(r, col)` and emit `'!'`. The only tricky case is `'z'` (row 5, col 0): it sits alone in the last row. When moving **to** `'z'`, we must move left before moving down (or we'd step off-board). When moving **from** `'z'`, we must move up before moving right.

The safe order is: always move **up** and **left** before **down** and **right** when targeting `'z'` (or from `'z'`). More precisely: move `U/L` first, then `D/R`.

**Algorithm:**
1. For each character in `target`, compute target `(tr, tc)`.
2. Compute deltas `dr = tr - cr`, `dc = tc - cc`.
3. Append moves in order: `U` (if `dr < 0`), `L` (if `dc < 0`), `D` (if `dr > 0`), `R` (if `dc > 0`), then `!`.
4. Update current position.

**Complexity:**

| | |
|---|---|
| Time | O(n * max_steps) = O(n) for target length n (steps bounded by board size) |
| Space | O(n) — output string |
