# 1489. Find Critical And Pseudo Critical Edges In Minimum Spanning Tree — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/

---

## Solution: Kruskal Variants — O(E^2 * alpha(n)) time, O(E) space

**Idea:** Find base MST weight. For each edge: check critical (remove it, see if MST weight increases or disconnects). Check pseudo-critical (force include it, see if MST weight stays same).

**Algorithm:**
1. Sort edges by weight. Find base MST weight W.
2. Critical: remove edge, build MST. If disconnected or weight > W, it's critical.
3. Pseudo-critical: force include edge, build rest of MST. If total == W, it's pseudo-critical.

**Complexity:**

| | |
|---|---|
| Time | O(E^2 * alpha(n)) |
| Space | O(E) |
