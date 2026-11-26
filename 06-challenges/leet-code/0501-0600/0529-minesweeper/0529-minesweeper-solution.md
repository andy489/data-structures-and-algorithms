# 529. Minesweeper — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minesweeper/

---

## Solution: DFS — O(m·n) time, O(m·n) space

**Idea:** Simulate the reveal process recursively. If a mine, mark `'X'`. If an empty cell, count adjacent mines. If count > 0, set digit. If count == 0, mark `'B'` and recurse on all 8 neighbors.

**Algorithm:**
1. If click hits `'M'`, set `'X'` and return.
2. Otherwise DFS from click: count adjacent mines in 8 directions.
3. If count > 0, set digit character and stop.
4. If count == 0, set `'B'` and recurse on all unrevealed (`'E'`) neighbors.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — each cell visited at most once |
| Space | O(m·n) — recursion stack |

---

## Solution 2: BFS — O(m·n) time, O(m·n) space

Same idea using an explicit queue instead of recursion.
