# 1263. Minimum Moves to Move a Box to Their Target Location — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-moves-to-move-a-box-to-their-target-location/

---

## Solution: BFS (0-1 BFS or Dijkstra) — O((m*n)^2) time, O((m*n)^2) space

**Idea:** State is (box_row, box_col, player_row, player_col). Moving the box costs 1; check if player can reach push position using BFS. Use Dijkstra/0-1 BFS.

**Algorithm:**
1. State: (box_r, box_c, player_r, player_c).
2. For each push direction: check player can reach push side (BFS), push costs 1.
3. Use deque BFS with cost tracking.

**Complexity:**

| | |
|---|---|
| Time | O((m*n)^2) |
| Space | O((m*n)^2) |
