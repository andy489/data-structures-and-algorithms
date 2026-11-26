# 1728. Cat and Mouse II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/cat-and-mouse-ii/

---

## Solution: Minimax with Memoization — O(m^2 · n^2 · (m+n)) time, O(m^2 · n^2) space

**Idea:** Model as a minimax game. State = `(mouseRow, mouseCol, catRow, catCol, turn)`. Mouse maximizes survival (wants to reach food), cat minimizes it (wants to intercept). Memoize to avoid recomputation. Limit turns to `m * n * 2` or 128 to detect draws/cat wins.

**Algorithm:**
1. Find initial positions from the grid.
2. Define `dp(mr, mc, cr, cc, turn)`: returns `true` if mouse wins from this state.
   - Base: if `turn >= maxTurns` or cat at mouse position → cat wins (return `false`).
   - Base: if mouse at food → mouse wins (return `true`).
   - Mouse's turn: try all moves (all distances in 4 dirs + stay). If any move leads to mouse win, return `true`.
   - Cat's turn: try all moves. If any move leads to cat win (not mouse win), return `false`. If all lead to mouse win, return `true`.
3. Use `memo[mr][mc][cr][cc][turn]` with three-value logic (true/false/unknown).

**Complexity:**

| | |
|---|---|
| Time | O(m^2 · n^2 · (m+n)) — states times transitions |
| Space | O(m^2 · n^2 · T) — memoization table |
