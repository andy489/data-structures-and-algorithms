# 1514. Path with Maximum Probability — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/path-with-maximum-probability/

---

## Solution: Modified Dijkstra (Max-Heap) — O((V + E) log V) time, O(V + E) space

**Idea:** This is Dijkstra's shortest path adapted for maximum probability. Use a max-heap keyed on probability. Start with probability 1.0 at `start`. For each neighbor, the new probability = current * edge probability. Skip a node if we've already found a higher probability.

**Algorithm:**
1. Build adjacency list: `adj[u] = [(v, p), ...]`.
2. `prob[i] = 0` for all, `prob[start] = 1.0`.
3. Max-heap: push `(-1.0, start)`.
4. While heap not empty:
   - Pop `(negP, u)`. If `-negP < prob[u]`, skip (stale).
   - If `u == end`, return `prob[u]`.
   - For each `(v, p)` in `adj[u]`: new prob = `prob[u] * p`. If > `prob[v]`, update and push.
5. Return 0.0.

**Complexity:**

| | |
|---|---|
| Time | O((V + E) log V) — Dijkstra with heap |
| Space | O(V + E) — adjacency list and prob array |
