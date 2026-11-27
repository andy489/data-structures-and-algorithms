# 130. Surrounded Regions — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/surrounded-regions/

---

## Solution 1: DFS from Border — O(m·n) time, O(m·n) space

**Idea:** Instead of identifying surrounded regions directly, mark all `'O'`s reachable from the border (they are *not* surrounded). Then flip: unvisited `'O'` → `'X'`, marked `'S'` → `'O'`.

**Algorithm:**
1. For every `'O'` on the four borders, run DFS and mark reachable `'O'`s as `'S'` (safe).
2. Scan the whole board: `'O'` → `'X'` (surrounded), `'S'` → `'O'` (restore safe).

**Complexity:**

| | |
|---|---|
| Time  | O(m·n) — each cell visited at most once |
| Space | O(m·n) — recursion stack in the worst case (all `'O'`) |

---

## Solution 2: BFS from Border — O(m·n) time, O(m·n) space

**Idea:** Same two-phase approach but uses an explicit BFS queue instead of recursion, avoiding stack-overflow risk on large all-`'O'` boards.

**Algorithm:**
1. Seed a queue with every border `'O'`; mark them `'S'`.
2. BFS: for each dequeued cell mark its `'O'` neighbours `'S'` and enqueue them.
3. Scan the board and apply the same final swap.

**Complexity:**

| | |
|---|---|
| Time  | O(m·n) — each cell enqueued at most once |
| Space | O(m·n) — queue size |
