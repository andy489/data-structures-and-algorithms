# 1129. Shortest Path with Alternating Colors — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/shortest-path-with-alternating-colors/

---

## Solution: BFS with Color State — O(n + E) time, O(n + E) space

**Idea:** BFS from node 0, tracking the color of the last edge used. The state is `(node, lastColor)`. We need to alternate colors, so from a state using RED we can only follow BLUE edges next, and vice versa. Use a visited set of `(node, color)` pairs to avoid revisiting.

**Algorithm:**
1. Build adjacency lists for red (color=0) and blue (color=1) edges separately.
2. Initialize BFS queue with `(0, RED)` and `(0, BLUE)` at distance 0 (node 0 is reachable with zero steps regardless of next color).
3. For each state `(node, color)`, explore all edges of the opposite color. Enqueue unvisited `(neighbor, oppositeColor)` states.
4. Track the minimum distance to each node across both color states.

**Complexity:**

| | |
|---|---|
| Time | O(n + E) — BFS visits each (node, color) state once |
| Space | O(n + E) — adjacency lists and visited set |
