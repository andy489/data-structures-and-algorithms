# 815. Bus Routes — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/bus-routes/

---

## Solution: BFS on Routes — O(Σ|route|) time, O(Σ|route|) space

**Idea:** BFS where each level represents taking one more bus. Build a stop→routes map; use a queue of stops. For each stop, try all buses through it; for each unseen bus, add all its stops.

**Algorithm:**
1. Build map: stop → list of route indices.
2. BFS from source. Use visited stops and visited routes.
3. For each stop, expand all unvisited routes, adding their stops.
4. Return number of buses taken when target is reached.

**Complexity:**

| | |
|---|---|
| Time | O(Σ|route|) — each stop and route visited once |
| Space | O(Σ|route|) — adjacency map and visited sets |
