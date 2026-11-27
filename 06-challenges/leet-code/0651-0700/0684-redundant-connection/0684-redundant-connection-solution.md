# 684. Redundant Connection — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/redundant-connection/

---

## Solution: Union-Find — O(n·α(n)) time, O(n) space

**Idea:** Use Union-Find. For each edge, if both endpoints are already in the same component, this edge creates a cycle — return it.

**Algorithm:**
1. Initialize parent array.
2. For each edge [u, v]: if find(u) == find(v), return edge.
3. Otherwise union(u, v).

**Complexity:**

| | |
|---|---|
| Time | O(n·α(n)) — nearly O(n) |
| Space | O(n) |
