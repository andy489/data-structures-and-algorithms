# 787. Cheapest Flights Within K Stops — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/cheapest-flights-within-k-stops/

---

## Solution: Bellman-Ford (K+1 relaxations) — O(K × E) time, O(n) space

**Idea:** Run Bellman-Ford for exactly K+1 rounds (at most K stops = K+1 edges). Use a copy of the distance array each round to avoid using edges from the same round.

**Algorithm:**
1. Initialize `dist[src] = 0`, all others = INF.
2. For K+1 iterations: copy dist; for each edge (u,v,w), relax: `newDist[v] = min(newDist[v], dist[u] + w)`.
3. Return `dist[dst]` or -1 if INF.

**Complexity:**

| | |
|---|---|
| Time | O(K × E) — K+1 passes over edges |
| Space | O(n) — distance arrays |
