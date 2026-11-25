# 913. Cat and Mouse — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/cat-and-mouse/

---

## Solution: BFS on Game States (Retrograde Analysis) — O(n³) time, O(n³) space

**Idea:** Model states as (mouse_pos, cat_pos, turn). Work backwards from terminal states: mouse at 0 → mouse wins; cat==mouse → cat wins. Propagate results using a BFS queue.

**Algorithm:**
1. Initialize: for each state where mouse=0 → MOUSE, cat=mouse → CAT.
2. BFS: for each resolved state, propagate to parent states.
3. If parent player would win with this result, mark it. Otherwise decrement degree; if 0, it's a draw (mark DRAW or leave as 0).

**Complexity:**

| | |
|---|---|
| Time | O(n³) — n² states × n moves |
| Space | O(n³) |
